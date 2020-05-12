package ctr;

public class Prozess {
	//
	double laufZeit;
	char prozessName;
	int priorit�t;
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

	public int getPriorit�t() {
		return priorit�t;
	}

	public void setPriorit�t(int priorit�t) {
		this.priorit�t = priorit�t;
	}

	public Prozess(double laufZeit, char prozessName, int priorit�t) {
		super();
		this.laufZeit = laufZeit;
		this.prozessName = prozessName;
		this.priorit�t = priorit�t;
	}

	public void giveCPUTime() {
		this.laufZeit -= 0.050;
		this.gesamtLaufZeit += 0.050;
		
	}

	public void giveTime() {
		this.gesamtLaufZeit += 0.050;
	}

	public void prioDown() {
		if (this.priorit�t > 0) {
			this.priorit�t--;
		}

	}

}