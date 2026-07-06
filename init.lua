local dap = require('dap')

dap.adapters.java = function(callback)
  callback({
    type = 'server',
    host = '127.0.0.1',
    port = 5005
  })
end

dap.configurations.java = {
  {
    type = 'java',
    request = 'launch',
    name = "Launch Java Program",
    mainClass = "Main",
    projectName = "your-project-name"
  }
}

Configuring **DAP (Debug Adapter Protocol) in Vim** is possible, but there are two realistic paths:

> ⚠️ Important: full DAP is *much better supported in Neovim* than classic Vim.

So I’ll show you:

1. ✅ Best modern way (Neovim — recommended)
2. ⚙️ Vim-compatible fallback (limited)

---

# 🚀 Option 1 (Recommended): Neovim + nvim-dap (real IDE debugging)

This is the standard way today.

---

## 📦 1. Install plugin manager (vim-plug)

```vim id="x9k2lm"
call plug#begin('~/.vim/plugged')

Plug 'mfussenegger/nvim-dap'
Plug 'rcarriga/nvim-dap-ui'

call plug#end()
```

Then:

```vim id="a8p3wx"
:PlugInstall
```

---

## ⚙️ 2. Basic DAP setup (init.lua)

Create:

```bash id="k2m9qp"
~/.config/nvim/init.lua
```

Add:

```lua id="p9x2lw"
local dap = require('dap')

-- Java example (generic launcher)
dap.configurations.java = {
  {
    type = 'java',
    request = 'launch',
    name = "Launch Java Program",
    mainClass = "Main"
  }
}
```

---

## 🎯 3. Key mappings

Put in `init.lua`:

```lua id="w8k2qz"
vim.keymap.set("n", "<F5>", function() require("dap").continue() end)
vim.keymap.set("n", "<F9>", function() require("dap").toggle_breakpoint() end)
vim.keymap.set("n", "<F10>", function() require("dap").step_over() end)
vim.keymap.set("n", "<F11>", function() require("dap").step_into() end)
vim.keymap.set("n", "<F12>", function() require("dap").step_out() end)
```

---

## 🧠 4. Add UI (like IntelliJ panels)

```lua id="c7p1lm"
require("dapui").setup()

local dap, dapui = require("dap"), require("dapui")

dap.listeners.after.event_initialized["dapui_config"] = function()
  dapui.open()
end

dap.listeners.before.event_terminated["dapui_config"] = function()
  dapui.close()
end
```

---

## 🚀 5. Install Java debug adapter

```bash id="t8p2lm"
git clone https://github.com/microsoft/java-debug.git
cd java-debug
./mvnw clean install
```

---

## ▶️ How to use

Inside Neovim:

| Action      | Key |
| ----------- | --- |
| Start debug | F5  |
| Breakpoint  | F9  |
| Step over   | F10 |
| Step into   | F11 |

---

# ⚙️ Option 2: Vim (classic) — limited DAP support

Classic Vim has no real native DAP UI, but you can use:

---

## 📦 Plugin

```vim id="v2k9lm"
Plug 'puremourning/vimspector'
```

---

## 🚀 Install vimspector

```vim id="n8q3wx"
:PlugInstall
```

Then:

```vim id="m3p9lz"
:VimspectorInstall java
```

---

## 🎯 Usage

```text id="k8m2qp"
:F5   start debugging
:F9   toggle breakpoint
:F10  step over
```

---

## 🧠 Why vimspector instead of raw DAP in Vim?

Because:

| Feature        | Vim + DAP | Vimspector |
| -------------- | --------- | ---------- |
| UI panels      | ❌         | ✔          |
| breakpoints    | ⚠️ manual | ✔          |
| variables view | ❌         | ✔          |
| ease of setup  | hard      | easy       |

---

# 🔥 Key reality check

| Setup  | Recommendation      |
| ------ | ------------------- |
| Vim    | use vimspector      |
| Neovim | use nvim-dap (best) |

---

# 🧠 Minimal working recommendation

If your goal is:

> “Java debugging like IntelliJ”

Then use:

```text id="q9m8wx"
Neovim + nvim-dap + nvim-dap-ui + nvim-jdtls
```

---

# 🚀 If you want next step

I can give you a **complete copy-paste IntelliJ-like setup**, including:

* Java autocomplete (coc or jdtls)
* project explorer
* debug sidebar UI
* Maven/Gradle support
* run/debug shortcuts like IntelliJ

Just tell me 👍
