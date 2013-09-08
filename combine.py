#!/usr/bin/python
import pandas as pd
import numpy

print "inthis"

activities = ["a01", "a02", "a03", "a04", "a05", "a06", "a07", "a08", "a09", "a10", "a11", "a12", "a13", "a14", "a15", "a16", "a17", "a18", "a19"]

people = ["p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"]

fileName = ["s01", "s02", "s03", "s04", "s05", "s06", "s07", "s08", "s09", "s10", "s11", "s12", "s13", "s14", "s15", "s16", "s17", "s18", "s19", "s20", "s21", "s22", "s23","s24","s25","s26","s27","s28","s29","s30","s31","s32","s33","s34","s35","s36","s37","s38","s39","s40","s41","s42","s43","s44","s45","s46","s47","s48","s49","s50","s51","s52","s53","s54","s55","s56","s57","s58","s59","s60"]

header = ["T1", "T1", "T1", "T1", "T1", "T1", "T1", "T1", "T1", "RA1", "RA2", "RA3", "RA4", "RA5", "RA6", "RA7", "RA8", "RA9", "LA1", "LA2", "LA3", "LA4", "LA5", "LA6", "LA7", "LA8", "LA9", "RL1", "RL2", "RL3", "RL4", "RL5", "RL6", "RL7", "RL8", "RL9", "LL1", "LL2", "LL3", "LL4", "LL5", "LL6", "LL7", "LL8", "LL9"]

for a in activities:
	print "inthis"
	for person in people:
		for fileN in fileName:
			if person == "p1":
				if fileN == "s01":
					print "chunk"
					print a
					print person
					print fileN
					chunk = pd.read_csv("/Users/bill/Desktop/HackAThon/data" + "/" + a + "/" + person + "/" + fileN + ".csv")
					print chunk
				else:
					additional = pd.read_csv("/Users/bill/Desktop/HackAThon/data" + "/" + a + "/" + person + "/" + fileN + ".csv")
					print additional
					chunk = pd.concat([chunk, additional], axis = 0)
	chunk.to_csv(a + ".csv")

