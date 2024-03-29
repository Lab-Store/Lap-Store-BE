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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Spec {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "spec_id")
	private Long id;

	@OneToOne(fetch = LAZY, cascade = ALL)
	@JoinColumn(
		name = "item_id",
		nullable = false,
		foreignKey = @ForeignKey(NO_CONSTRAINT))
	private Item item;

	@Column(name = "inch", nullable = false)
	private Double inch;

	@Column(name = "cpu", nullable = false)
	private String cpu;

	@Column(name = "ram", nullable = false)
	private Integer ram;

	@Column(name = "ssd", nullable = false)
	private Integer ssd;

	@Column(name = "color", nullable = false)
	private Color color;

	@Column(name = "thickness", nullable = false)
	private Double thickness;

	@Column(name = "weight", nullable = false)
	private Double weight;

	@Builder
	private Spec(
		Item item, Double inch, String cpu, Integer ram,
		Integer ssd, Color color, Double thickness, Double weight
	) {
		this.item = item;
		this.inch = inch;
		this.cpu = cpu;
		this.ram = ram;
		this.ssd = ssd;
		this.color = color;
		this.thickness = thickness;
		this.weight = weight;
	}
}
