import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
@Slf4j
public class Demo {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        //获取T_REPAY_FINANCE_DETAIL状态等于4的订单号
        String str = "101004_201909291529158507864";
        String[] orderIds = str.split(",");
        for (String orderId : orderIds) {
            log.info("资金端还款失败重试orderId:{}", orderId);
            restTemplate.delete("http://10.253.126.9:9999/trade-web/trade/deleteTrade?orderId=" + orderId);
            Object object = restTemplate.getForObject("http://10.253.126.9:9999/finance-repay-support/repay/repayRetry/" + orderId + "/S", Object.class);
            log.info("资金端还款失败重试orderId:{}，data:{}", orderId,object);
        }
    }

}

