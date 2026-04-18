File I/O in Spring Boot is mostly about **handling HTTP requests that carry files** (upload) and **serving files back** (download). Under the hood, it combines:

* Spring MVC (`@RestController`)
* Multipart handling
* Java I/O / NIO (`Files`, `Path`)
* HTTP response streaming

Let’s walk through it step by step.

---

# 🧭 1. Big Picture

### Upload flow

```text
Client → HTTP multipart request → Spring → save to disk/cloud
```

### Download flow

```text
Client → HTTP request → Spring → read file → stream response
```

---

# 📤 2. File Upload in Spring Boot

## 2.1 Dependency (already included)

Spring Boot starter:

```xml
spring-boot-starter-web
```

👉 Includes multipart support automatically.

---

## 2.2 Configuration (optional)

```properties
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=20MB
```

---

## 2.3 Controller Example

```java
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;

@RestController
@RequestMapping("/files")
public class FileController {

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {

        Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());

        Files.createDirectories(path.getParent());

        Files.write(path, file.getBytes());

        return "Uploaded: " + file.getOriginalFilename();
    }
}
```

---

## 2.4 Key Concepts

### `MultipartFile`

```java
file.getOriginalFilename();
file.getInputStream();
file.getBytes();
file.getSize();
```

👉 Represents uploaded file

---

## 2.5 Better Practice (Streaming)

Avoid loading entire file into memory:

```java
Files.copy(file.getInputStream(), path);
```

---

# 📥 3. File Download in Spring Boot

---

## 3.1 Basic Download

```java
@GetMapping("/download/{filename}")
public ResponseEntity<byte[]> download(@PathVariable String filename) throws Exception {

    Path path = Paths.get("uploads/" + filename);
    byte[] data = Files.readAllBytes(path);

    return ResponseEntity.ok()
        .header("Content-Disposition", "attachment; filename=" + filename)
        .body(data);
}
```

---

## 3.2 Streaming Download (Better for Large Files)

```java
@GetMapping("/download-stream/{filename}")
public ResponseEntity<Resource> downloadStream(@PathVariable String filename) throws Exception {

    Path path = Paths.get("uploads/" + filename);

    Resource resource = new UrlResource(path.toUri());

    return ResponseEntity.ok()
        .header("Content-Disposition", "attachment; filename=" + filename)
        .body(resource);
}
```

---

## 3.3 Why Streaming?

* Avoids loading full file into memory
* Handles large files efficiently

---

# 📁 4. File Storage Options

---

## 4.1 Local Disk

```text
/uploads/file.txt
```

👉 Simple, good for small apps

---

## 4.2 Cloud Storage

* AWS S3
* Google Cloud Storage

👉 Common in production

---

## 4.3 Database (Not recommended)

* Only for small files (BLOB)
* Poor performance for large files

---

# 🔐 5. Security Considerations (VERY IMPORTANT)

---

## 5.1 Path Traversal Attack

❌ Dangerous:

```java
Paths.get("uploads/" + filename);
```

User input could be:

```text
../../etc/passwd
```

---

### ✅ Fix

```java
Path base = Paths.get("uploads").toAbsolutePath().normalize();
Path target = base.resolve(filename).normalize();

if (!target.startsWith(base)) {
    throw new RuntimeException("Invalid path");
}
```

---

## 5.2 File Type Validation

```java
if (!file.getContentType().equals("image/png")) {
    throw new RuntimeException("Only PNG allowed");
}
```

---

## 5.3 File Size Limits

Use configuration (already shown)

---

# ⚙️ 6. Advanced Features

---

## 6.1 Multiple File Upload

```java
@PostMapping("/upload-multiple")
public String uploadMultiple(@RequestParam("files") MultipartFile[] files) {
    for (MultipartFile file : files) {
        // save each file
    }
    return "Uploaded multiple files";
}
```

---

## 6.2 Upload + Metadata

```java
@PostMapping("/upload")
public String upload(
    @RequestParam("file") MultipartFile file,
    @RequestParam("userId") String userId
) {
    // store file + metadata
}
```

---

## 6.3 Async File Processing

Use:

* `@Async`
* or thread pool

---

# 📦 7. Service Layer Design (Best Practice)

---

## Controller

```java
@PostMapping("/upload")
public String upload(@RequestParam MultipartFile file) {
    fileService.save(file);
    return "ok";
}
```

---

## Service

```java
@Service
public class FileService {

    public void save(MultipartFile file) {
        // validation
        // storage
    }
}
```

---

# 🚀 8. Real-World Enhancements

* File versioning
* Unique file names (UUID)

```java
String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
```

* CDN integration
* Image resizing (Thumbnails)

---

# 🧠 9. Interview-Level Insights

---

### ❓ Difference: `byte[]` vs `Resource`

| Type     | Use             |
| -------- | --------------- |
| byte[]   | small files     |
| Resource | large/streaming |

---

### ❓ Why not `file.getBytes()`?

* Loads entire file into memory
* Bad for large files

---

### ❓ How does Spring handle multipart?

Internally:

* Uses `MultipartResolver`
* Parses HTTP request into `MultipartFile`

---

### ❓ Best practice for production?

* Store files in **cloud (S3)**
* Store metadata in DB
* Use streaming

---

# 🧭 10. Mental Model

Upload:

```text
MultipartFile → InputStream → Files.copy → Disk
```

Download:

```text
Disk → Resource/InputStream → HTTP Response
```

---

# 🔚 Final Summary

* Use `MultipartFile` for uploads
* Use `Resource` for downloads
* Prefer **streaming over loading into memory**
* Always validate input (security!)
* Separate controller + service

---

If you want, I can go deeper into:

* File upload to AWS S3 in Spring Boot
* Chunked upload (large files like videos)
* Resume download support (HTTP Range)

Just tell me 👍
