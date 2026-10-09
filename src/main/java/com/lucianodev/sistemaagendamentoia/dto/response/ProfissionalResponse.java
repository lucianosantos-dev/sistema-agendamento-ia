package com.lucianodev.sistemaagendamentoia.dto.response;

import java.util.UUID;

public record ProfissionalResponse(
        UUID id,
        String nome,
        String especialidade
) {
}
