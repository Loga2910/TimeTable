package com.example.RemainderSystem;
import java.time.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemainderController {
	
	@Autowired
	private RemainderDao rdao;
	
	@PostMapping("/remainder")
	public String save(@RequestBody RemainderEntity r)
	{
		return rdao.save(r)+" records stored";
	}
	
	@GetMapping("/remainder")
	public List<RemainderEntity> selectall()
	{
		return rdao.findall();
	}
	
	@GetMapping("/remainder/{id}")
	public RemainderEntity search(@PathVariable int id)
	{
		return rdao.findById(id);
	}
	
	@PutMapping("/remainder/{id}")
	public String update(@RequestBody RemainderEntity r,@PathVariable int id)
	{
		return rdao.updateById(r, id)+" records updated";
	}
	
	@DeleteMapping("/remainder/{id}")
	public String delete(@PathVariable int id)
	{
		return rdao.deleteById(id)+" records deleted";
	}
	
	@GetMapping("/remainder/check") 
	public List<String> checkReminders() {
        List<RemainderEntity> all = rdao.findall();   // fetch all reminders

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        return all.stream()
                .filter(r ->
                    (!today.isBefore(r.getStart_Date())) &&   // today >= start
                    (!today.isAfter(r.getEnd_Date()))         // today <= end
                )
                .map(r -> {
                    long minutes = java.time.Duration.between(now, r.getRemainder_Time()).toMinutes();

                    if (minutes > 0) {
                        return r.getTitle() + " → " + minutes + " minutes to go";
                    } else if (minutes == 0) {
                        return r.getTitle() + " → Reminder time now!";
                    } else {
                        return r.getTitle() + " → Reminder time passed " + Math.abs(minutes) + " minutes ago";
                    }
                })    .toList();
    }
}

	

