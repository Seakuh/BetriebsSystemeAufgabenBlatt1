package ctr;

public class Prozess {
	//
	double laufZeit;
	char prozessName;
	int priorität;
	double gesamtLaufZeit;

	public double getGesamtLaufZeit() {
		return gesamtLaufZeit;
	}

	public void setGesamtLaufZeit(double gesamtLaufZeit) {
		this.gesamtLaufZeit = gesamtLaufZeit;
	}

	public double getLaufZeit() {
		return laufZeit;
	}

	public void setLaufZeit(int laufZeit) {
		this.laufZeit = laufZeit;
	}

	public char getProzessName() {
		return prozessName;
	}

	public void setProzessName(char prozessName) {
		this.prozessName = prozessName;
	}

	public int getPriorität() {
		return priorität;
	}

	public void setPriorität(int priorität) {
		this.priorität = priorität;
	}

	public Prozess(double laufZeit, char prozessName, int priorität) {
		super();
		this.laufZeit = laufZeit;
		this.prozessName = prozessName;
		this.priorität = priorität;
	}

	public void giveCPUTime() {
		this.laufZeit -= 0.050;
		this.gesamtLaufZeit += 0.050;
		
	}

	public void giveTime() {
		this.gesamtLaufZeit += 0.050;
	}

	public void prioDown() {
		if (this.priorität > 0) {
			this.priorität--;
		}

	}

}