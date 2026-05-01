package ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import service.EstoqueService;

@SpringBootApplication(scanBasePackages = {"ui", "service", "repository", "model", "controller"})@EntityScan("model")
@EnableJpaRepositories("repository")
public class Main {
    public static void main(String[] args) {
        // Iniciamos o contexto do Spring e guardamos na variável 'context'
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        // Em vez de dar 'new', pedimos ao Spring para nos dar o service configurado
        EstoqueService service = context.getBean(EstoqueService.class);

        // Passamos esse service para o Menu
        Menu menu = new Menu(service);
        menu.exibir();
    }
}