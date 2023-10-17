import matplotlib.pyplot as plt

data_file = "TP_Systemes_intelligents_avances\TP1_Systemes_Intelligents_avances\FUN"
x =[]
y = []
with open(data_file,"r") as file:
    for line in file:
        values = line.strip().split()
        if(len(values)) == 2:
            x.append(float(values[0]))
            y.append(float(values[1]))

plt.figure(figsize=(8,6))
plt.scatter(x,y,s = 30,marker="o",label="Front de Pareto")
plt.xlabel("F1(à minimiser)")
plt.ylabel("F2(à maximiser)")
plt.title("Front de Pareto")
plt.legend()
plt.grid(True)

plt.show()