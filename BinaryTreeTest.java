import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void testInsertAndSearch() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();
        Association<String, String> assoc1 = new Association<>("dog", "perro");
        Association<String, String> assoc2 = new Association<>("house", "casa");

        tree.insert(assoc1);
        tree.insert(assoc2);

        Association<String, String> searchDummy = new Association<>("dog", null);
        Association<String, String> result = tree.search(searchDummy);
        assertNotNull(result);
        assertEquals("perro", result.getValue());

        Association<String, String> dummyFail = new Association<>("cat", null);
        assertNull(tree.search(dummyFail));
    }
}