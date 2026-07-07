SUBROUTINE SHELLSORT(ARR, N)
INTEGER N
INTEGER ARR(N)

INTEGER GAP, I, J, TEMP

! Start with a large gap and reduce it by half each time
GAP = N / 2
DO WHILE (GAP .GT. 0)
   ! Perform a gapped insertion sort for the current gap
   DO I = GAP + 1, N
      TEMP = ARR(I)
      J = I
      
      ! Shift earlier gap-sorted elements until the correct position is found
      DO WHILE (J .GT. GAP .AND. ARR(J - GAP) .GT. TEMP)
         ARR(J) = ARR(J - GAP)
         J = J - GAP
      END DO
      
      ARR(J) = TEMP
   END DO
   GAP = GAP / 2
END DO

RETURN
END
