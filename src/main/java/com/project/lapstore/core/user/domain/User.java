package com.project.lapstore.core.user.domain;

import static com.project.lapstore.core.common.exception.CommonValidationError.*;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import org.springframework.util.Assert;

import com.project.lapstore.core.common.entity.TimeBaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class User extends TimeBaseEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "name", nullable = false)
	private String name;

	private void validateUser(
		String email,
		String password,
		String name
	) {
		Assert.hasText(email, getNotEmptyMessage("User", "email"));
		Assert.hasText(password, getNotEmptyMessage("User", "password"));
		Assert.hasText(name, getNotEmptyMessage("User", "name"));
	}

	private User(Long id, String email, String password, String name) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
	}

	@Builder
	private User(String email, String password, String name) {
		validateUser(email, password, name);
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public static User of(String email, String password, String name) {
		return User.builder()
			.email(email)
			.password(password)
			.name(name)
			.build();
	}

	/**
	 * 테스트 용 생성자
	 */
	public static User getTestUser(
		Long id,
		String email,
		String password,
		String name
	) {
		return new User(id, email, password, name);
	}
}
