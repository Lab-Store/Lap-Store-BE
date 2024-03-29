package com.project.lapstore.core.item.domain.entity;

import static com.project.lapstore.core.common.exception.CommonValidationError.*;
import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import org.springframework.util.Assert;

import com.project.lapstore.core.common.entity.TimeBaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Item extends TimeBaseEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "item_id")
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Enumerated(STRING)
	@Column(name = "brand", nullable = false)
	private Brand brand;

	@Enumerated(STRING)
	@Column(name = "category", nullable = false)
	private Category category;

	@Column(name = "bookmark_count")
	private int bookmarkCount = 0;

	@Column(name = "lowest_price")
	private int lowestPrice = 0;

	@Builder
	private Item(
		String name,
		Brand brand,
		Category category
	) {
		validateItem(name, brand);
		this.name = name;
		this.brand = brand;
		this.category = category;
	}

	private void validateItem(String name, Brand brand) {
		Assert.hasText(name, getNotEmptyMessage("Item", "name"));
		Assert.notNull(brand, getNotNullMessage("Item", "brand"));
	}

	public static Item of(
		String name,
		Brand brand,
		Category category
	) {
		return Item.builder()
			.name(name)
			.brand(brand)
			.category(category)
			.build();
	}

}
