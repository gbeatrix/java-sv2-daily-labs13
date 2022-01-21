package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransferAggregatorTest {
    @Test
    void testEverything(){
        TransferAggregator transferAggregator = new TransferAggregator();
        List<TransferPerClient> result = transferAggregator.readTransfers(Path.of("src/main/resources/transfers.csv"));
        assertEquals(20, result.size());

        transferAggregator.writeTransfers(Path.of("src/main/resources/transfers-sum.txt"));
    }
}