package org.st20043420.assignment2;

public class ReadingVariables {
	private double gps_x, gps_y, euler_phi, euler_psi, euler_theta,
	acc_forward, acc_sideways, acc_up, gyr1, gyr2, gyr3, mag_forward, mag_sideways, mag_up, music_track;
	
	public ReadingVariables(double gps_x, double gps_y, double euler_phi,
			double euler_psi, double euler_theta, double acc_forward,
			double acc_sideways, double acc_up, double gyr1, double gyr2,
			double gyr3, double mag_forward, double mag_sideways,
			double mag_up, double music_track) {
		super();
		this.gps_x = gps_x;
		this.gps_y = gps_y;
		this.euler_phi = euler_phi;
		this.euler_psi = euler_psi;
		this.euler_theta = euler_theta;
		this.acc_forward = acc_forward;
		this.acc_sideways = acc_sideways;
		this.acc_up = acc_up;
		this.gyr1 = gyr1;
		this.gyr2 = gyr2;
		this.gyr3 = gyr3;
		this.mag_forward = mag_forward;
		this.mag_sideways = mag_sideways;
		this.mag_up = mag_up;
		this.music_track = music_track;
	}

	public double getGps_x() {
		return gps_x;
	}

	public void setGps_x(double gps_x) {
		this.gps_x = gps_x;
	}

	public double getGps_y() {
		return gps_y;
	}

	public void setGps_y(double gps_y) {
		this.gps_y = gps_y;
	}

	public double getEuler_phi() {
		return euler_phi;
	}

	public void setEuler_phi(double euler_phi) {
		this.euler_phi = euler_phi;
	}

	public double getEuler_psi() {
		return euler_psi;
	}

	public void setEuler_psi(double euler_psi) {
		this.euler_psi = euler_psi;
	}

	public double getEuler_theta() {
		return euler_theta;
	}

	public void setEuler_theta(double euler_theta) {
		this.euler_theta = euler_theta;
	}

	public double getAcc_forward() {
		return acc_forward;
	}

	public void setAcc_forward(double acc_forward) {
		this.acc_forward = acc_forward;
	}

	public double getAcc_sideways() {
		return acc_sideways;
	}

	public void setAcc_sideways(double acc_sideways) {
		this.acc_sideways = acc_sideways;
	}

	public double getAcc_up() {
		return acc_up;
	}

	public void setAcc_up(double acc_up) {
		this.acc_up = acc_up;
	}

	public double getGyr1() {
		return gyr1;
	}

	public void setGyr1(double gyr1) {
		this.gyr1 = gyr1;
	}

	public double getGyr2() {
		return gyr2;
	}

	public void setGyr2(double gyr2) {
		this.gyr2 = gyr2;
	}

	public double getGyr3() {
		return gyr3;
	}

	public void setGyr3(double gyr3) {
		this.gyr3 = gyr3;
	}

	public double getMag_forward() {
		return mag_forward;
	}

	public void setMag_forward(double mag_forward) {
		this.mag_forward = mag_forward;
	}

	public double getMag_sideways() {
		return mag_sideways;
	}

	public void setMag_sideways(double mag_sideways) {
		this.mag_sideways = mag_sideways;
	}

	public double getMag_up() {
		return mag_up;
	}

	public void setMag_up(double mag_up) {
		this.mag_up = mag_up;
	}

	public double getMusic_track() {
		return music_track;
	}

	public void setMusic_track(double music_track) {
		this.music_track = music_track;
	}
	
}
