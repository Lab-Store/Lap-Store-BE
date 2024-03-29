package com.project.lapstore.core.item.dto.request;

import java.util.List;

import com.project.lapstore.core.item.domain.entity.Brand;
import com.project.lapstore.core.item.domain.entity.Category;
import com.project.lapstore.core.item.domain.entity.Color;
import com.project.lapstore.core.item.domain.entity.TagType;

public record RegisterItemRequest(

	String name,
	Brand brand,
	Category category,
	List<TagType> tagTypes,
	Double inch,
	String cpu,
	Integer ram,
	Integer ssd,
	Color color,
	Double thickness,
	Double weight
) {
}
