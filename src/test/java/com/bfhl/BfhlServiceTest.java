package com.bfhl;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import com.bfhl.service.BfhlService;
import com.bfhl.service.impl.BfhlServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BfhlServiceTest {

    private final BfhlService service = new BfhlServiceImpl(
            "Madhav Sharma",
            "madhav1335.be23@chitkara.edu.in",
            "2310991335",
            "24062026"
    );

    @Test
    public void testExampleA() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("a", "1", "334", "4", "R", "$"));
        BfhlResponse resp = service.process(req);
        assertTrue(resp.isIs_success());
        assertEquals("madhav_sharma_24062026", resp.getUser_id());
        assertEquals("madhav1335.be23@chitkara.edu.in", resp.getEmail());
        assertEquals("2310991335", resp.getRoll_number());
        assertEquals("[1]", resp.getOdd_numbers().toString());
        assertEquals("[334, 4]", resp.getEven_numbers().toString());
        assertEquals("[A, R]", resp.getAlphabets().toString());
        assertEquals("[$]", resp.getSpecial_characters().toString());
        assertEquals("339", resp.getSum());
        assertEquals("Ra", resp.getConcat_string());
    }

    @Test
    public void testExampleB() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));
        BfhlResponse resp = service.process(req);
        assertTrue(resp.isIs_success());
        assertEquals("[5]", resp.getOdd_numbers().toString());
        assertEquals("[2, 4, 92]", resp.getEven_numbers().toString());
        assertEquals("[A, Y, B]", resp.getAlphabets().toString());
        assertEquals("[&, -, *]", resp.getSpecial_characters().toString());
        assertEquals("103", resp.getSum());
        assertEquals("ByA", resp.getConcat_string());
    }

    @Test
    public void testExampleC() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("A", "ABCD", "DOE"));
        BfhlResponse resp = service.process(req);
        assertTrue(resp.isIs_success());
        assertEquals("[]", resp.getOdd_numbers().toString());
        assertEquals("[]", resp.getEven_numbers().toString());
        assertEquals("[A, ABCD, DOE]", resp.getAlphabets().toString());
        assertEquals("[]", resp.getSpecial_characters().toString());
        assertEquals("0", resp.getSum());
        assertEquals("EoDdCbAa", resp.getConcat_string());
    }

    @Test
    public void testNullRequestIsHandledGracefully() {
        BfhlResponse resp = service.process(null);
        assertTrue(resp.isIs_success());
        assertEquals("madhav_sharma_24062026", resp.getUser_id());
        assertEquals("[]", resp.getOdd_numbers().toString());
        assertEquals("[]", resp.getEven_numbers().toString());
        assertEquals("[]", resp.getAlphabets().toString());
        assertEquals("[]", resp.getSpecial_characters().toString());
        assertEquals("0", resp.getSum());
        assertEquals("", resp.getConcat_string());
    }
}
