package ctr;

import java.text.Collator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Test {

	public static void ausgabe(LinkedList<Prozess> prozesse) {
		System.out.println("Name   Prio  LaufZeit Gesamt");
		for (Prozess p : prozesse) {
			System.out.println(p.prozessName + "\t" + p.priorität + "\t" + p.laufZeit + "\t" + p.gesamtLaufZeit);
		}
		System.out.println("----------------------------------------");
	}

	public static void prioritätsSchedulingBerechnung(LinkedList<Prozess> prozesse) {

		Prozess maxPrio = new Prozess(0, 'm', 0);
		for (Iterator it = prozesse.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		Prozess a = prozesse.get(0);
		Prozess b = prozesse.get(1);
		Prozess c = prozesse.get(2);
		Prozess d = prozesse.get(3);
		Prozess e = prozesse.get(4);

		while (!(a.laufZeit == 0 && (b.laufZeit == 0) && (c.laufZeit == 0) && (d.laufZeit == 0) && (e.laufZeit == 0))) {

			for (Prozess p : prozesse) {

				if ((p.priorität >= maxPrio.priorität) && (p.laufZeit != 0)) {
					maxPrio = p;
				}
				if (p.laufZeit != 0 && !(p.equals(maxPrio))) {
					p.giveTime();
				}
			}

			maxPrio.giveCPUTime();
			maxPrio.prioDown();

			for (Prozess p : prozesse) {
				System.out.println(p.prozessName + "\t" + p.priorität + "\t" + p.laufZeit + "\t" + p.gesamtLaufZeit);
			}

			System.out.println("----------------------------------------");
			System.out.println("Name   Prio  LaufZeit Gesamt");

		}
	}

	public static void main(String[] args) {

		LinkedList<Prozess> prozesse = new LinkedList<Prozess>();

		Prozess a = new Prozess(10, 'A', 3);
		Prozess b = new Prozess(6, 'B', 5);
		Prozess c = new Prozess(2, 'C', 2);
		Prozess d = new Prozess(4, 'D', 1);
		Prozess e = new Prozess(8, 'E', 4);

		prozesse.add(a);
		prozesse.add(b);
		prozesse.add(c);
		prozesse.add(d);
		prozesse.add(e);

		ausgabe(prozesse);
		// prioritätsSchedulingBerechnung(prozesse);
		//firstComeFirtstServe(prozesse);
		// shortesJobFirst(prozesse);
		roundRobin(prozesse);
	}

	private static void firstComeFirtstServe(LinkedList<Prozess> prozesse) {

		double laufzeitGes = 0;

		for (Prozess p : prozesse) {
			laufzeitGes += p.laufZeit;
			System.out.println(p.prozessName + "\t" + p.priorität + "\t" + p.laufZeit + "\t" + laufzeitGes);
			p.gesamtLaufZeit = laufzeitGes;

		}

		double durchschnitt = laufzeitGes / prozesse.size();

		System.out.println("durchschnittliche Laufzeit: " + durchschnitt);

		System.out.println("----------------------------------------");

	}

	private static void shortesJobFirst(LinkedList<Prozess> prozesse) {

		int laufz = 0;

		Prozess shortest = prozesse.getFirst();
		while (!(prozesse.isEmpty())) {
			for (Prozess p : prozesse) {
				if (p.laufZeit <= shortest.laufZeit) {
					shortest = p;
				}
			}
			laufz += shortest.laufZeit;
			System.out.println(
					shortest.prozessName + "\t" + shortest.priorität + "\t" + shortest.laufZeit + "\t" + laufz);
			prozesse.remove(shortest);
			if (!(prozesse.isEmpty())) {
				shortest = prozesse.getFirst();
			}

		}
	}

	public static void roundRobin(LinkedList<Prozess> prozesse) {

		while (!(prozesse.isEmpty())) {
			for (Prozess p : prozesse) {
				if(p.laufZeit<0) {
					prozesse.remove(p);
				}
				p.giveCPUTime();
				ausgabe(prozesse);
			}
		}

	}
}