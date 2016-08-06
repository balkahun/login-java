package app.user;

import lombok.*;
@Value public class user {
	String username;
	    String salt;
	    String hashedPassword;
}
