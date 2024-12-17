package daw1.emprestimo_de_ferramentas.services.front;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import daw1.emprestimo_de_ferramentas.entities.UsuarioEntity;

@Service
public class ListAllUsuariosService {
    
    public List<UsuarioEntity> execute() {
        RestTemplate rt = new RestTemplate();
        HttpEntity<Object> httpEntity = new HttpEntity<>(null);
        
        ParameterizedTypeReference<List<UsuarioEntity>> responseType = new ParameterizedTypeReference<List<UsuarioEntity>>() {};

        var result = rt.exchange(
            "http://localhost:8080/api/usuarios/get",
            HttpMethod.GET,
            httpEntity,
            responseType
        );
        
        return result.getBody();
    }
}
