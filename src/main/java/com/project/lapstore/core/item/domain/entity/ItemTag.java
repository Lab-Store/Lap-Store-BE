package com.project.lapstore.core.item.domain.entity;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.ConstraintMode.*;
import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class ItemTag {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "item_tag_id")
	private Long id;

	@OneToOne(fetch = LAZY, cascade = ALL)
	@JoinColumn(
		name = "item_id",
		nullable = false,
		foreignKey = @ForeignKey(NO_CONSTRAINT))
	private Item item;

	@Column(name = "name", nullable = false)
	private String name;
}
