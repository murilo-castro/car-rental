package mtech.car.rental.infra.http;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Resposta da requisição", description = "Representação padrão do conteúdo das respostas")
public class Response {
    ResponseStatus status;

    @Schema(description = "Corpo da Resposta da requisição que pode ser uma lista, um objeto ou um erro")
    Object body;
}
