import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PracticeProblemTest {

   // --- swap() Tests ---

   @Test
   @DisplayName("swap should swap two elements at valid indices in an ArrayList")
   void swapTest1() {
      Class<?> testClass = PracticeProblem.class;
      try {
         ArrayList<String> list = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
         Class<?>[] cArg = { ArrayList.class, int.class, int.class };
         Method method = testClass.getDeclaredMethod("swap", cArg);
         method.invoke(null, list, 1, 3);
         
         ArrayList<String> expected = new ArrayList<>(Arrays.asList("Red", "Yellow", "Blue", "Green"));
         assertEquals(expected, list);
      } catch (NoSuchMethodException e) {
         fail("Method swap does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   @Test
   @DisplayName("swap should result in no change when swapping an index with itself")
   void swapTest2() {
      Class<?> testClass = PracticeProblem.class;
      try {
         ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
         Class<?>[] cArg = { ArrayList.class, int.class, int.class };
         Method method = testClass.getDeclaredMethod("swap", cArg);
         method.invoke(null, list, 0, 0);
         
         ArrayList<String> expected = new ArrayList<>(Arrays.asList("A", "B", "C"));
         assertEquals(expected, list);
      } catch (NoSuchMethodException e) {
         fail("Method swap does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   // --- createArrayList() Tests ---

   @Test
   @DisplayName("createArrayList should convert a double array to an ArrayList correctly")
   void createArrayListTest1() {
      Class<?> testClass = PracticeProblem.class;
      try {
         double[] input = {1.1, 2.2, 3.3};
         Class<?>[] cArg = { double[].class };
         Method method = testClass.getDeclaredMethod("createArrayList", cArg);
         ArrayList<Double> result = (ArrayList<Double>) method.invoke(null, (Object) input);
         
         ArrayList<Double> expected = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3));
         assertEquals(expected, result);
      } catch (NoSuchMethodException e) {
         fail("Method createArrayList does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   @Test
   @DisplayName("createArrayList should return an empty ArrayList when given an empty array")
   void createArrayListTest2() {
      Class<?> testClass = PracticeProblem.class;
      try {
         double[] input = {};
         Class<?>[] cArg = { double[].class };
         Method method = testClass.getDeclaredMethod("createArrayList", cArg);
         ArrayList<Double> result = (ArrayList<Double>) method.invoke(null, (Object) input);
         
         assertNotNull(result);
         assertEquals(0, result.size());
      } catch (NoSuchMethodException e) {
         fail("Method swap does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   // --- mergeLists() Tests ---

   @Test
   @DisplayName("mergeLists should combine two lists in the specified order")
   void mergeListsTest1() {
      Class<?> testClass = PracticeProblem.class;
      try {
         ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
         ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4));
         Class<?>[] cArg = { ArrayList.class, ArrayList.class };
         Method method = testClass.getDeclaredMethod("mergeLists", cArg);
         ArrayList<Integer> result = (ArrayList<Integer>) method.invoke(null, list1, list2);
         
         ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
         assertEquals(expected, result);
      } catch (NoSuchMethodException e) {
         fail("Method mergeLists does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   @Test
   @DisplayName("mergeLists should return a new list and not modify the original inputs")
   void mergeListsTest2() {
      Class<?> testClass = PracticeProblem.class;
      try {
         ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(10));
         ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(20));
         Class<?>[] cArg = { ArrayList.class, ArrayList.class };
         Method method = testClass.getDeclaredMethod("mergeLists", cArg);
         ArrayList<Integer> result = (ArrayList<Integer>) method.invoke(null, list1, list2);
         
         // Verify result is correct
         assertEquals(new ArrayList<>(Arrays.asList(10, 20)), result);
         // Verify originals are untouched
         assertEquals(1, list1.size());
         assertEquals(1, list2.size());
         // Verify it's a new instance
         assertNotSame(result, list1);
         assertNotSame(result, list2);
      } catch (NoSuchMethodException e) {
         fail("Method swap does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   @Test
   @DisplayName("mergeLists should handle merging when one or both lists are empty")
   void mergeListsTest3() {
      Class<?> testClass = PracticeProblem.class;
      try {
         ArrayList<Integer> list1 = new ArrayList<>();
         ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(5, 6, 7));
         Class<?>[] cArg = { ArrayList.class, ArrayList.class };
         Method method = testClass.getDeclaredMethod("mergeLists", cArg);
         
         ArrayList<Integer> result = (ArrayList<Integer>) method.invoke(null, list1, list2);
         assertEquals(new ArrayList<>(Arrays.asList(5, 6, 7)), result);
         
         ArrayList<Integer> bothEmpty = (ArrayList<Integer>) method.invoke(null, new ArrayList<>(), new ArrayList<>());
         assertEquals(0, bothEmpty.size());
      } catch (NoSuchMethodException e) {
         fail("Method swap does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }
}