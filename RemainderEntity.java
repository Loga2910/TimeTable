package com.example.RemainderSystem;
import java.time.*;

public class RemainderEntity {
	private int id;
	private String Title;
	private LocalDate Start_Date ;
	private LocalDate End_Date;
	private LocalTime Remainder_Time;
	public RemainderEntity() {
		// TODO Auto-generated constructor stub
	}

	public RemainderEntity(int id, String Title, LocalDate Start_Date, LocalDate End_Date, LocalTime Remainder_Time) {
		super();
		this.id = id;
		this.Title=Title;
		this.Start_Date=Start_Date;
		this.End_Date=End_Date;
		this.Remainder_Time=Remainder_Time;
	}

	public RemainderEntity(String Title, LocalDate Start_Date, LocalDate End_Date, LocalTime Remainder_Time) {
		super();
		this.Title=Title;
		this.Start_Date=Start_Date;
		this.End_Date=End_Date;
		this.Remainder_Time=Remainder_Time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public LocalDate getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(LocalDate start_Date) {
		Start_Date = start_Date;
	}

	public LocalDate getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(LocalDate end_Date) {
		End_Date = end_Date;
	}

	public LocalTime getRemainder_Time() {
		return Remainder_Time;
	}

	public void setRemainder_Time(LocalTime remainder_Time) {
		Remainder_Time = remainder_Time;
	}
	
	@Override
	public String toString() {
		return "RemainderEntity [id=" + id + ", Title=" + Title + ", Start_Time=" + Start_Date + ", End_Date" + End_Date +",Remainder_Time=" +Remainder_Time
				+ "]";
	}
	
}
	
	