package com.allen;

import java.time.LocalDate;

public record Student(
			int id,
			String name,
			String email,
			LocalDate dob,
			String phone,
			String address,
			String course,
			String gender
		)
{
	
	
	
}
