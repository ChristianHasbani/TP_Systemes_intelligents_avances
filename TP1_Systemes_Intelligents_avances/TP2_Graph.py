import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.patches as patches

# Read the coordinates from the CSV file
df = pd.read_csv("coordinates.csv")

# Separate targets and sensors
targets = df[df["Type"] == "Target"]
sensors = df[df["Type"] == "Sensor"]

# Plot the targets
plt.scatter(targets["X"], targets["Y"], label="Targets", color="blue")

# Plot the sensors
plt.scatter(sensors["X"], sensors["Y"], label="Sensors", color="red")

# Plot circles around sensors with a radius of 10
for index, sensor in sensors.iterrows():
    circle = patches.Circle((sensor["X"], sensor["Y"]), radius=10, edgecolor="red", facecolor="none", linestyle="--")
    plt.gca().add_patch(circle)

plt.xlabel("X-coordinate")
plt.ylabel("Y-coordinate")
plt.title("Targets and Sensors Placement with Radius")
plt.legend()
plt.show()
