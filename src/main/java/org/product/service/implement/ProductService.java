package org.product.service.implement;

import org.product.common.PathShop;
import org.product.model.DTO.Shopee.BaseResponse;
import org.product.model.DTO.Shopee.ModelList;
import org.product.model.DTO.Shopee.Product;
import org.product.service.interfaceCustomer.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.function.Consumer;

@Service
public class ProductService implements IProductService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public BaseResponse getDataIntegration(int page, int size){
        String path ="/mpsku/list/v2/get_product_list";

        //build header
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Host", "banhang.shopee.vn");
//        httpHeaders.add("accept", "application/json, text/plain, */*");
//        httpHeaders.add("accept-language", "en-US,en;q=0.9,vi;q=0.8");
//        httpHeaders.add("cache-control", "no-cache");
//        httpHeaders.add("pragma", "no-cache");
//        httpHeaders.add("priority", "u=1, i");
//        httpHeaders.add("referer", "https://banhang.shopee.vn/portal/product/list/live/all");
//        httpHeaders.add("sc-fe-session", "930548302DD56AB8");
//        httpHeaders.add("sc-fe-ver", "21.89705");
////        httpHeaders.add("sec-ch-ua", "Not(A:Brand\";v=\"99\", \"Google Chrome\";v=\"133\", \"Chromium\";v=\"133\"");
//        httpHeaders.add("sec-ch-ua-mobile", "?0");
////        httpHeaders.add("sec-ch-ua-platform", "\"Windows\"");
//        httpHeaders.add("sec-fetch-dest", "empty");
//        httpHeaders.add("sec-fetch-mode", "cors");
//        httpHeaders.add("sec-fetch-site", "same-origin");
//        httpHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/133.0.0.0 Safari/537.36");
        httpHeaders.add("Cookie", "fulfillment-language=vi; SPC_CDS=7dc085ed-a073-40f5-9396-fd53539106fe;SPC_EC=.a3hBV1lKd3phWUlKUFZuYeU02IHdeQhEh3t8zkXom7QiZCkyMaWTafVVpTe/vYkyDZDg+Cfsn2Y/DPUEDXBi3BSTF5U6Gp9hU2EMJ0jKzP3UX4Ka9Oe93h4bt5giz2Vl3ycxNtxcCWfHoEFZYFaN3zFujUTnP7pRxzzUUCy6SjIlL3HfpM8BmXaEIW1Oi19iHQ+g7ungJOg5wfobZ1ZHhGkLQJlysOKQdho5moo7ufR6k3GlQkwII1GhVFgAPI2l; SPC_SC_SESSION=g70ZIngNgzFd1XBLLoRVUnGAvOBSAdRgCPX7sbkkEe/dYfsBMTR9GZu0uVpWJJvJAfyNcl8tLYkJ9ma8iFaM/LOtWtDb3xZ4IC2qJcWZSxvI/NS98GIRarFagt5bw/BH55+PRH2XgIDr/B8/2aa6vPQ605rgbkpyzO3nMzsu0ckVbElNf4OcKlOq67QZ5xROaYlTkqyQV30g3up17WfpZEhQSxXhtPHAgghT+YaNpkuwOBj8r4bPPd1rOpRPafD6i+5L7Wst4vPt0vbp/U+0Zeg==_1_59431828;");
        Consumer<HttpHeaders> headersConsumer = headers -> {
            headers.addAll(httpHeaders);
        };

        //build queryParam
        URI uri = UriComponentsBuilder.fromHttpUrl(PathShop.SHOPEE)
                .path(path)
                .queryParam("SPC_CDS", "7dc085ed-a073-40f5-9396-fd53539106fe")
                .queryParam("SPC_CDS_VER", "2")
                .queryParam("page_number", page)
                .queryParam("page_size", size)
                .queryParam("list_type", "live_all")
                .queryParam("live_allc", "true")
                .queryParam("category", "electronics")
                .queryParam("page", 2)
                .build()
                //.buildAndExpand(456)  // Thay thế {productId} bằng 456
                .toUri();

//        RestClient defaultClient = RestClient.create();
//        String result2 = defaultClient.get()
//                .uri(uri)
//                .headers(headersConsumer)
//                .retrieve()
//                .body(String.class)  // Sử dụng bodyToMono thay vì body
//                ;

        var result2 = webClient.get()
                .uri(uri)
                .headers(headersConsumer)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> {
                    // Xử lý lỗi client 4xx
                    HttpStatusCode httpStatusCode = response.statusCode();
                    System.out.println("Client Error occurred with status code: " + httpStatusCode);

                    // Trả về một Mono hợp lệ từ lỗi 4xx
                    return response.bodyToMono(String.class)
                            .flatMap(body -> {
                                // Xử lý body lỗi
                                System.out.println("Error body: " + body);
                                // Trả về một Mono.error() hợp lệ, không phải null
                                return Mono.error(new RuntimeException("Client error occurred with message: " + body));
                            });
                })
                .onStatus(HttpStatusCode::is5xxServerError, response -> {
                    // Xử lý lỗi server 5xx
                    return Mono.error(new RuntimeException("Server Error occurred"));
                })
                .bodyToMono(BaseResponse.class)
                .block()// Lấy body từ phản hồi thành công
//                .doOnTerminate(() -> {
//                    System.out.println("Request completed");
//                })
//                .subscribe(result -> {
//                    System.out.println("Result: " + result);
//                }, error -> {
//                    // Xử lý lỗi tại đây
//                    System.err.println("Error: " + error.getMessage());
//                })
                ;

        // Gọi API từ bên ngoài với phương thức GET
//        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
//        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
//
//        // Lấy nội dung của body trong phản hồi
//        String result1 = response.getBody();
        List<Product> abc = result2.getData().getProducts();
        for(Product product : abc) {
            List<ModelList> modelLists = product.getModel_list();
            int sumAvailable = modelLists.stream()
                    .mapToInt(m -> m.getStock_detail().getTotal_available_stock()).sum();
            product.setAvailable_product(sumAvailable);
            int sumSeller = modelLists.stream()
                    .mapToInt(m -> m.getStock_detail().getTotal_seller_stock()).sum();
            product.setSeller_product(sumSeller);
        }
        return result2;
    }
}
