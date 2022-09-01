package com.sportskirezultati.auth.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Dto for registration response.
 */
@Data
@Builder
public class RegisterResponse {

  private List<String> errors;
}
