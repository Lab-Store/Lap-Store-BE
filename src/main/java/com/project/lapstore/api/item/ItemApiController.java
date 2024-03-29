package com.project.lapstore.api.item;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.lapstore.api.auth.jwt.JwtAuthorization;
import com.project.lapstore.core.item.dto.request.RegisterItemRequest;
import com.project.lapstore.core.item.dto.response.ItemDetailResponse;
import com.project.lapstore.core.item.service.ItemService;
import com.project.lapstore.core.user.domain.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "상품 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/items")
public class ItemApiController {

	private final ItemService itemService;

	@PostMapping
	@Operation(summary = "상품 등록 API", description = "상품을 등록한다")
	@ApiResponse(useReturnTypeSchema = true)
	public ResponseEntity<Long> registerItem(
		@Parameter(hidden = true) @JwtAuthorization User user,
		final @Valid @RequestBody RegisterItemRequest request
	) {
		Long registeredItemId = itemService.registerItem(request);
		return ResponseEntity.ok(registeredItemId);
	}

	@GetMapping("/{itemId}")
	@Operation(summary = "상품 조회 API", description = "상품을 상세 조회한다")
	@ApiResponse(useReturnTypeSchema = true)
	public ResponseEntity<ItemDetailResponse> getItemDetail(
		@PathVariable Long itemId
	) {
		ItemDetailResponse response = itemService.getItemDetail(itemId);
		return ResponseEntity.ok(response);
	}

	//수정

	//삭제

	// 조건에 따른 전체 조회
}
