#!/usr/bin/python
import pandas as pd
import numpy

print "inthis"

activities = ["a01", "a02", "a03", "a04", "a05", "a06", "a07", "a08", "a09", "a10", "a11", "a12", "a13", "a14", "a15", "a16", "a17", "a18", "a19"]

people = ["p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"]

fileName = ["s01.txt", "s02.txt", "s03.txt", "s04.txt", "s05.txt", "s06.txt", "s07.txt", "s08.txt", "s09.txt", "s10.txt", "s11.txt", "s12.txt", "s13.txt", "s14.txt", "s15.txt", "s16.txt", "s17.txt", "s18.txt", "s19.txt", "s20.txt", "s21.txt", "s22.txt", "s23.txt","s24.txt","s25.txt","s26.txt","s27.txt","s28.txt","s29.txt","s30.txt","s31.txt","s32.txt","s33.txt","s34.txt","s35.txt","s36.txt","s37.txt","s38.txt","s39.txt","s40.txt","s41.txt","s42.txt","s43.txt","s44.txt","s45.txt","s46.txt","s47.txt","s48.txt","s49.txt","s50.txt","s51.txt","s52.txt","s53.txt","s54.txt","s55.txt","s56.txt","s57.txt","s58.txt","s59.txt","s60.txt"]

modifiedFileName = ["s01", "s02", "s03", "s04", "s05", "s06", "s07", "s08", "s09", "s10", "s11", "s12", "s13", "s14", "s15", "s16", "s17", "s18", "s19", "s20", "s21", "s22", "s23","s24","s25","s26","s27","s28","s29","s30","s31","s32","s33","s34","s35","s36","s37","s38","s39","s40","s41","s42","s43","s44","s45","s46","s47","s48","s49","s50","s51","s52","s53","s54","s55","s56","s57","s58","s59","s60"]


header = ["T1", "T1", "T1", "T1", "T1", "T1", "T1", "T1", "T1", "RA1", "RA2", "RA3", "RA4", "RA5", "RA6", "RA7", "RA8", "RA9", "LA1", "LA2", "LA3", "LA4", "LA5", "LA6", "LA7", "LA8", "LA9", "RL1", "RL2", "RL3", "RL4", "RL5", "RL6", "RL7", "RL8", "RL9", "LL1", "LL2", "LL3", "LL4", "LL5", "LL6", "LL7", "LL8", "LL9"]

for a in activities:
	print "inthis"
	for person in people:
		for fileN in modifiedFileName:
			chunk = pd.read_csv("/Users/bill/Desktop/HackAThon/data" + "/" + a + "/" + person + "/" + fileN + ".txt", names=header)
			chunk.to_csv("/Users/bill/Desktop/HackAThon/data" + "/" + a + "/" + person + "/" + fileN + ".csv")