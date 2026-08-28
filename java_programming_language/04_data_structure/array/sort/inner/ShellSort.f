      SUBROUTINE SHELLSORT(ARR, N)
      INTEGER ARR(N), N
      INTEGER GAP, I, J, TEMP
C
C     Start with the largest gap and reduce by half each time
      GAP = N / 2
10    IF (GAP .GT. 0) THEN
         DO 30 I = GAP + 1, N
            TEMP = ARR(I)
            J = I
C
C           Shift elements of the gap-sorted array
20          IF (J .GT. GAP .AND. ARR(J - GAP) .GT. TEMP) THEN
               ARR(J) = ARR(J - GAP)
               J = J - GAP
               GO TO 20
            END IF
C
            ARR(J) = TEMP
30       CONTINUE
         GAP = GAP / 2
         GO TO 10
      END IF
C
      RETURN
      END
