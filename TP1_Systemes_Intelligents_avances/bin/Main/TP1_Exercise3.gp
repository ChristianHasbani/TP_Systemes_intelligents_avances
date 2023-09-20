set output "FrontPareto.eps"
set xlabel "f1 (to minimize)"
set ylabel "f2 (to maximize)"

set key right bottom

set style data linespoints

set term post eps enhanced color solid "Helvetica" 18

plot [*:*][*:*] 'FUN_NSGAII.txt' using 1:2 title "PF NASGA-II",\
'FUN_SPEA2.txt' using 1:2 title "PF_SPEA2"