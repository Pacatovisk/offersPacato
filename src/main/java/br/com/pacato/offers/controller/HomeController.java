package br.com.pacato.offers.controller;

import br.com.pacato.offers.model.Pedido;
import br.com.pacato.offers.model.StatusPedido;
import br.com.pacato.offers.repository.PedidoRepository;
import br.com.pacato.offers.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model){
        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
