package com.example.i77ki.feel2color_test1;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by i77ki on 7/6/2018.
 */

public class Entry {

	private Color color;
	private int id;
	private String dateTime;
	Random r = new Random();
	private int rand = r.nextInt(100000 - 1) + 1;



	public void setEntry(Color color) {
		this.id = this.rand;
		this.color = color;
		this.dateTime = String.valueOf(System.currentTimeMillis());
	}

	public String getId() {
		return String.valueOf(this.id);
	}

	public String getTime(){
		return String.valueOf(this.dateTime);
	}

	public Color getColor(){
		return(this.color);
	}



}
