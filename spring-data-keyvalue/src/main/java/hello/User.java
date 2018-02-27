package hello;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

//@KeySpace("user")
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class User {

	@Id String uuid;
	String firstname;
}