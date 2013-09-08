#!/usr/bin/python
import pandas as pd
from dateutil import parser

new = pd.read_csv("/Users/bill/Desktop/HackAThon/APIData/stepsActual.csv")

new["dateTime"] = ""


for x in new["date"]:
	old = parser.parse(x)
	print old.day
	new["day"] = old.day

# for y in new["time"]:
# 	time = parser.parse(y)
# 	print time.hour
# 	new["hour"] = time.hour

# for x in new["calories"]:
# 	date = new["date"]
# 	time = new["time"]
# 	dateTime = date + " " + time
# 	new["dateTime"] = dateTime

new.to_csv("stepsDone.csv")