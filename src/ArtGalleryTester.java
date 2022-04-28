// TODO Complete file header must be added here

import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * ArtworkGallery.
 *
 * @author TODO add your name(s)
 *
 */

public class ArtGalleryTester {

  /**
   * Checks the correctness of the implementation of both compareTo() and equals() methods defined
   * in the Artwork class.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testArtworkCompareToEquals() {

    // Add the artist name
    try {
      // Testing the implementation of the compareTo() method
      // Testing for cases which return 0
      Artwork obj = new Artwork("Mona Lisa", 2000, 30.0);
      Artwork objToCompare = new Artwork("Mona Lisa", 2000, 30.0);

      if (obj.compareTo(objToCompare) != 0) {
        return false;
      }

      // Testing for cases which return -1
      Artwork obj2 = new Artwork("Mona Lisa", 1500, 30.0);
      Artwork objToCompare2 = new Artwork("Mona Lisa", 2000, 30.0);

      if (!(obj2.compareTo(objToCompare2) < 0)) {
        return false;
      }

      Artwork obj3 = new Artwork("Mona Lisa", 2000, 28.0);
      Artwork objToCompare3 = new Artwork("Mona Lisa", 2000, 30.0);

      if (!(obj3.compareTo(objToCompare3) < 0)) {
        return false;
      }

      Artwork obj4 = new Artwork("Mona", 2000, 30.0);
      Artwork objToCompare4 = new Artwork("Mona Lisa", 2000, 30.0);

      if (!(obj4.compareTo(objToCompare4) < 0)) {
        return false;
      }

      // Testing for cases which return 1
      Artwork obj5 = new Artwork("Mona Lisa", 2000, 30.0);
      Artwork objToCompare5 = new Artwork("Mona", 2000, 30.0);

      if (!(obj5.compareTo(objToCompare5) > 0)) {
        return false;
      }

      Artwork obj6 = new Artwork("Mona Lisa", 2000, 30.0);
      Artwork objToCompare6 = new Artwork("Mona", 1500, 30.0);

      if (!(obj6.compareTo(objToCompare6) > 0)) {
        return false;
      }

      Artwork obj7 = new Artwork("Mona Lisa", 2000, 32.0);
      Artwork objToCompare7 = new Artwork("Mona", 2000, 30.0);

      if (!(obj7.compareTo(objToCompare7) > 0)) {
        return false;
      }

      // Testing the implementation of the equals() method
      Object obj8 = new Object();
      Artwork obj9 = new Artwork("Mona Lisa", 2000, 30.0);
      if (obj8.equals(obj9) != false) {
        return false;
      }

      Artwork obj10 = new Artwork("Mona Lisa", 2001, 30.0);
      Artwork objToCompare10 = new Artwork("Mona Lisa", 2000, 30.0);
      if (obj10.equals(objToCompare10) != false) {
        return false;
      }

      Artwork obj11 = new Artwork("Mona", 2000, 30.0);
      Artwork objToCompare11 = new Artwork("Mona Lisa", 2000, 30.0);
      if (obj11.equals(objToCompare11) != false) {
        return false;
      }

      Artwork obj12 = new Artwork("Mona Lisa", 2000, 31.0);
      Artwork objToCompare12 = new Artwork("Mona Lisa", 2000, 30.0);
      if (obj12.equals(objToCompare12) != true) {
        return false;
      }

      Artwork obj13 = new Artwork("Mona Lisa", 2000, 30.0);
      Artwork objToCompare13 = new Artwork("Mona Lisa", 2000, 30.0);
      if (obj13.equals(objToCompare13) != true) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of the implementation of both addArtwork() and toString() methods
   * implemented in the ArtworkGallery class. This unit test considers at least the following
   * scenarios. (1) Create a new empty ArtworkGallery, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one artwork and then
   * check that the addArtwork() method call returns true, the tree is not empty, its size is 1, and
   * the .toString() called on the tree returns the expected output. (3) Try adding another artwork
   * which is smaller that the artwork at the root, (4) Try adding a third artwork which is greater
   * than the one at the root, (5) Try adding at least two further artwork such that one must be
   * added at the left subtree, and the other at the right subtree. For all the above scenarios, and
   * more, double check each time that size() method returns the expected value, the add method call
   * returns true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * artwork with respect to year, cost, and then name. (6) Try adding a artwork already stored in
   * the tree. Make sure that the addArtwork() method call returned false, and that the size of the
   * tree did not change.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddArtworkToStringSize() {
    try {
      // Case: 1
      ArtGallery tree = new ArtGallery();
      if (tree.size() != 0) {
        return false;
      }

      if (tree.toString().trim() != "") {
        return false;
      }

      // Case: 2
      Artwork artWorkToAdd = new Artwork("Mona Lisa, DaVinci", 1503, 1000.0);
      if (tree.addArtwork(artWorkToAdd) != true || tree.isEmpty() != false || tree.size() != 1) {
        return false;
      }
      String expected = "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected.trim()))) {
        return false;
      }

      // Case: 3
      Artwork artWorkToAdd2 = new Artwork("Mona Lisa, DaVinci", 1500, 1000.0);
      if (tree.addArtwork(artWorkToAdd2) != true || tree.isEmpty() != false || tree.size() != 2) {
        return false;
      }
      String expected2 = "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected2.trim()))) {
        return false;
      }

      Artwork artWorkToAdd3 = new Artwork("Mona Lisa, DaVinci", 1510, 1000.0);
      if (tree.addArtwork(artWorkToAdd3) != true || tree.isEmpty() != false || tree.size() != 3) {
        return false;
      }
      String expected3 = "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1510) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected3.trim()))) {
        return false;
      }

      Artwork artWorkToAdd4 = new Artwork("Mona Lisa, DaVinci", 1520, 1000.0);
      if (tree.addArtwork(artWorkToAdd4) != true || tree.isEmpty() != false || tree.size() != 4) {
        return false;
      }
      String expected4 = "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1510) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1520) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected4.trim()))) {
        return false;
      }

      Artwork artWorkToAdd5 = new Artwork("Mona Lisa, DaVinci", 1515, 1000.0);
      if (tree.addArtwork(artWorkToAdd5) != true || tree.isEmpty() != false || tree.size() != 5) {
        return false;
      }
      String expected5 = "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1510) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1515) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1520) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected5.trim()))) {
        return false;
      }

      Artwork artWorkToAdd6 = new Artwork("Mona Lisa, DaVinci", 1490, 1000.0);
      if (tree.addArtwork(artWorkToAdd6) != true || tree.isEmpty() != false || tree.size() != 6) {
        return false;
      }
      String expected6 = "[(Name: Mona Lisa, DaVinci) (Year: 1490) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1510) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1515) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1520) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected6.trim()))) {
        return false;
      }

      Artwork artWorkToAdd7 = new Artwork("Mona Lisa, DaVinci", 1496, 1000.0);
      if (tree.addArtwork(artWorkToAdd7) != true || tree.isEmpty() != false || tree.size() != 7) {
        return false;
      }
      String expected7 = "[(Name: Mona Lisa, DaVinci) (Year: 1490) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1496) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1510) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1515) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1520) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected7.trim()))) {
        return false;
      }

      // Case 4: When trying to add an artwork already stored in the tree
      Artwork artWorkToAdd8 = new Artwork("Mona Lisa, DaVinci", 1496, 1000.0);
      if (tree.addArtwork(artWorkToAdd8) != false || tree.size() != 7) {
        return false;
      }
      String expected8 = "[(Name: Mona Lisa, DaVinci) (Year: 1490) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1496) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1510) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1515) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1520) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected8.trim()))) {
        return false;
      }

      // CASE 5: Checking if null pointer exception is thrown when artwork to add is null
      Artwork artWorkToAdd9 = new Artwork("Mona Lisa, DaVinci", 2000, 1000.0);
      artWorkToAdd9 = null;
      try {
        tree.addArtwork(artWorkToAdd9);
        return false;
      } catch (NullPointerException e) {
        if (e.getMessage() == null || e.getMessage().length() == 0) {
          return false;
        }
      } catch (Exception e) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * This method checks mainly for the correctness of the ArtworkGallery.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ArtworkGallery. Then, check
   * that calling the lookup() method on an empty ArtworkGallery returns false. (2) Consider a
   * ArtworkGallery of height 3 which lookup at least 5 artwork. Then, try to call lookup() method
   * to search for the artwork having a match at the root of the tree. (3) Then, search for a
   * artwork at the right and left subtrees at different levels considering successful and
   * unsuccessful search operations. Make sure that the lookup() method returns the expected output
   * for every method call.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    try {
      ArtGallery tree = new ArtGallery();
      if (tree.lookup("Gaurav", 1001, 1001.0) != false) {
        return false;
      }

      Artwork artWorkToAdd = new Artwork("Mona Lisa, DaVinci", 1503, 1000.0);
      tree.addArtwork(artWorkToAdd);
      Artwork artWorkToAdd2 = new Artwork("Mona Lisa, DaVinci", 1500, 1000.0);
      tree.addArtwork(artWorkToAdd2);
      Artwork artWorkToAdd3 = new Artwork("Mona Lisa, DaVinci", 1490, 1000.0);
      tree.addArtwork(artWorkToAdd3);
      Artwork artWorkToAdd4 = new Artwork("Mona Lisa, DaVinci", 1496, 1000.0);
      tree.addArtwork(artWorkToAdd4);
      Artwork artWorkToAdd5 = new Artwork("Mona Lisa, DaVinci", 1510, 1000.0);
      tree.addArtwork(artWorkToAdd5);
      Artwork artWorkToAdd6 = new Artwork("Mona Lisa, DaVinci", 1515, 1000.0);
      tree.addArtwork(artWorkToAdd6);
      Artwork artWorkToAdd7 = new Artwork("Mona Lisa, DaVinci", 1520, 1000.0);
      tree.addArtwork(artWorkToAdd7);

      if (tree.lookup("Mona Lisa, DaVinci", 1503, 1000.0) != true) {
        return false;
      }

      if (tree.lookup("Mona Lisa, DaVinci", 1500, 1000.0) != true) {
        return false;
      }

      if (tree.lookup("Mona Lisa, DaVinci", 1490, 1000.0) != true) {
        return false;
      }

      if (tree.lookup("Mona Lisa, DaVinci", 1496, 1000.0) != true) {
        return false;
      }

      if (tree.lookup("Mona Lisa, DaVinci", 1510, 1000.0) != true) {
        return false;
      }

      if (tree.lookup("Mona Lisa, DaVinci", 1515, 1000.0) != true) {
        return false;
      }

      if (tree.lookup("Mona Lisa, DaVinci", 1520, 1000.0) != true) {
        return false;
      }

      // Invalid implementation
      if (tree.lookup("Mona Lisa, DaVinci", 1519, 1000.0) != false) {
        return false;
      }

      if (tree.lookup("Mona Lisa, DaVinci", 1520, 1001.0) != false) {
        return false;
      }

      if (tree.lookup("Mon Lisa, DaVinci", 1520, 1000.0) != false) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ArtworkGallery.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty artwork tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ArtworkGallery with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*) (*)
   * (*) / (*)
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    ArtGallery tree = new ArtGallery();

    if (tree.height() != 0) {
      return false;
    }

    // Testing height when only root is present
    Artwork artWorkToAdd = new Artwork("Mona Lisa, DaVinci", 1503, 1000.0);
    tree.addArtwork(artWorkToAdd);
    if (tree.height() != 1) {
      return false;
    }

    // Testing height when more than root is present
    Artwork artWorkToAdd2 = new Artwork("Mona Lisa, DaVinci", 1505, 1000.0);
    tree.addArtwork(artWorkToAdd2);
    Artwork artWorkToAdd3 = new Artwork("Mona Lisa, DaVinci", 1501, 1000.0);
    tree.addArtwork(artWorkToAdd3);
    if (tree.height() != 2) {
      return false;
    }

    Artwork artWorkToAdd4 = new Artwork("Mona Lisa, DaVinci", 1507, 1000.0);
    tree.addArtwork(artWorkToAdd4);
    if (tree.height() != 3) {
      return false;
    }

    Artwork artWorkToAdd5 = new Artwork("Mona Lisa, DaVinci", 1502, 1000.0);
    tree.addArtwork(artWorkToAdd5);
    if (tree.height() != 3) {
      return false;
    }

    Artwork artWorkToAdd6 = new Artwork("Mona Lisa, DaVinci", 1504, 1000.0);
    tree.addArtwork(artWorkToAdd6);
    if (tree.height() != 3) {
      return false;
    }

    Artwork artWorkToAdd7 = new Artwork("Mona Lisa, DaVinci", 1506, 1000.0);
    tree.addArtwork(artWorkToAdd7);
    if (tree.height() != 4) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ArtworkGallery.getBestArtwork() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestArtwork() {
    ArtGallery tree = new ArtGallery();
    Artwork artWorkToAdd = new Artwork("Mona Lisa, DaVinci", 1503, 1000.0);
    tree.addArtwork(artWorkToAdd);
    if (!(tree.getBestArtwork().equals(artWorkToAdd))) {
      return false;
    }
    Artwork artWorkToAdd2 = new Artwork("Mona Lisa, DaVinci", 1500, 1000.0);
    tree.addArtwork(artWorkToAdd2);
    if (!(tree.getBestArtwork().equals(artWorkToAdd))) {
      return false;
    }

    Artwork artWorkToAdd3 = new Artwork("Mona Lisa, DaVinci", 1490, 1000.0);
    tree.addArtwork(artWorkToAdd3);
    if (!(tree.getBestArtwork().equals(artWorkToAdd))) {
      return false;
    }
    Artwork artWorkToAdd4 = new Artwork("Mona Lisa, DaVinci", 1496, 1000.0);
    tree.addArtwork(artWorkToAdd4);
    if (!(tree.getBestArtwork().equals(artWorkToAdd))) {
      return false;
    }

    Artwork artWorkToAdd5 = new Artwork("Mona Lisa, DaVinci", 1510, 1000.0);
    tree.addArtwork(artWorkToAdd5);
    if (!(tree.getBestArtwork().equals(artWorkToAdd5))) {
      return false;
    }

    Artwork artWorkToAdd6 = new Artwork("Mona Lisa, DaVinci", 1515, 1000.0);
    tree.addArtwork(artWorkToAdd6);
    if (!(tree.getBestArtwork().equals(artWorkToAdd6))) {
      return false;
    }

    Artwork artWorkToAdd7 = new Artwork("Mona Lisa, DaVinci", 1520, 1000.0);
    tree.addArtwork(artWorkToAdd7);
    if (!(tree.getBestArtwork().equals(artWorkToAdd7))) {
      return false;
    }

    Artwork artWorkToAdd8 = new Artwork("Mona Lisa, DaVinci", 1517, 1000.0);
    tree.addArtwork(artWorkToAdd8);
    if (!(tree.getBestArtwork().equals(artWorkToAdd7))) {
      return false;
    }

    Artwork artWorkToAdd9 = new Artwork("Mona Lisa, DaVinci", 1520, 2000.0);
    tree.addArtwork(artWorkToAdd9);
    if (!(tree.getBestArtwork().equals(artWorkToAdd9))) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }


  /**
   * Checks for the correctness of ArtworkGallery.lookupAll() method. This test must consider at
   * least 3 test scenarios. (1) Ensures that the ArtworkGallery.lookupAll() method returns an empty
   * arraylist when called on an empty tree. (2) Ensures that the ArtworkGallery.lookupAll() method
   * returns an array list which contains all the artwork satisfying the search criteria of year and
   * cost, when called on a non empty artwork tree with one match, and two matches and more. Vary
   * your search criteria such that the lookupAll() method must check in left and right subtrees.
   * (3) Ensures that the ArtworkGallery.lookupAll() method returns an empty arraylist when called
   * on a non-empty artwork tree with no search results found.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookupAll() {
    try {
      ArtGallery tree = new ArtGallery();
      ArrayList<Artwork> expected = new ArrayList<Artwork>();
      if (!(tree.lookupAll(2002, 2500.0).equals(expected))) {
        return false;
      }

      Artwork artWorkToAdd = new Artwork("Mona Lisa, DaVinci", 1503, 1100.0);
      tree.addArtwork(artWorkToAdd);
      Artwork artWorkToAdd2 = new Artwork("Mona Lisa, DaVinci", 1500, 1200.0);
      tree.addArtwork(artWorkToAdd2);
      Artwork artWorkToAdd3 = new Artwork("Mona Lisa, DaVinci", 1490, 1150.0);
      tree.addArtwork(artWorkToAdd3);
      Artwork artWorkToAdd4 = new Artwork("Mona Lisa, DaVinci", 1496, 1400.0);
      tree.addArtwork(artWorkToAdd4);
      Artwork artWorkToAdd5 = new Artwork("Mona Lisa, DaVinci", 1510, 1250.0);
      tree.addArtwork(artWorkToAdd5);
      Artwork artWorkToAdd6 = new Artwork("Mona Lisa, DaVinci", 1515, 1300.0);
      tree.addArtwork(artWorkToAdd6);
      Artwork artWorkToAdd7 = new Artwork("Mona Lisa, DaVinci", 1520, 1150.0);
      tree.addArtwork(artWorkToAdd7);

      // Checking with a price and year that does not match
      if (!(tree.lookupAll(1600, 1000.0).equals(expected))) {
        return false;
      }

      // Checking with a valid max year but with a price that does not match
      if (!(tree.lookupAll(1600, 2500.0).equals(expected))) {
        return false;
      }

      // Check with a matching year but an invalid price
      if (!(tree.lookupAll(1496, 1000.0).equals(expected))) {
        return false;
      }

      // Checking valid combinations such that search results are found
      expected.add(artWorkToAdd5);
      if (!(tree.lookupAll(1510, 1500.0).equals(expected))) {
        return false;
      }

      Artwork artWorkToAdd8 = new Artwork("Mona Lisa, DaVinci", 1510, 1300.0);
      tree.addArtwork(artWorkToAdd8);
      if (!(tree.lookupAll(1510, 1250.0).equals(expected))) {
        return false;
      }

      // Giving error from here
      ArrayList<Artwork> expected2 = new ArrayList<Artwork>();
      expected2.add(artWorkToAdd5);
      expected2.add(artWorkToAdd8);

      if (!(tree.lookupAll(1510, 1800.0).equals(expected2))) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ArtworkGallery.buyArtwork() method. This test must consider at
   * least 3 test scenarios. (1) Buying artwork that is at leaf node (2) Buying artwork at non-leaf
   * node (3) ensures that the ArtworkGallery.buyArtwork() method throws a NoSuchElementException
   * when called on an artwork that is not present in the BST
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBuyArtwork() {
    try {
      ArtGallery tree = new ArtGallery();

      Artwork artWorkToAdd = new Artwork("Mona Lisa, DaVinci", 1503, 1000.0);
      tree.addArtwork(artWorkToAdd);
      Artwork artWorkToAdd2 = new Artwork("Mona Lisa, DaVinci", 1500, 1000.0);
      tree.addArtwork(artWorkToAdd2);
      Artwork artWorkToAdd3 = new Artwork("Mona Lisa, DaVinci", 1490, 1000.0);
      tree.addArtwork(artWorkToAdd3);
      Artwork artWorkToAdd4 = new Artwork("Mona Lisa, DaVinci", 1496, 1000.0);
      tree.addArtwork(artWorkToAdd4);
      Artwork artWorkToAdd5 = new Artwork("Mona Lisa, DaVinci", 1510, 1000.0);
      tree.addArtwork(artWorkToAdd5);
      Artwork artWorkToAdd6 = new Artwork("Mona Lisa, DaVinci", 1515, 1000.0);
      tree.addArtwork(artWorkToAdd6);
      Artwork artWorkToAdd7 = new Artwork("Mona Lisa, DaVinci", 1520, 1000.0);
      tree.addArtwork(artWorkToAdd7);
      Artwork artWorkToAdd8 = new Artwork("Mona Lisa, DaVinci", 1514, 1000.0);
      tree.addArtwork(artWorkToAdd8);
      Artwork artWorkToAdd9 = new Artwork("Mona Lisa, DaVinci", 1530, 1000.0);
      tree.addArtwork(artWorkToAdd9);

      tree.buyArtwork("Mona Lisa, DaVinci", 1530, 1000.0);
      String expected = "[(Name: Mona Lisa, DaVinci) (Year: 1490) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1496) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1510) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1514) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1515) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1520) (Cost: $1000.0)]" + "\n";

      if (!(tree.toString().trim().equals(expected.trim()))) {
        return false;
      }

      tree.buyArtwork("Mona Lisa, DaVinci", 1490, 1000.0);
      String expected2 = "[(Name: Mona Lisa, DaVinci) (Year: 1496) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1510) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1514) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1515) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1520) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected2.trim()))) {
        return false;
      }

      tree.buyArtwork("Mona Lisa, DaVinci", 1515, 1000.0);
      String expected3 = "[(Name: Mona Lisa, DaVinci) (Year: 1496) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1510) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1514) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1520) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected3.trim()))) {
        return false;
      }

      tree.buyArtwork("Mona Lisa, DaVinci", 1510, 1000.0);
      String expected4 = "[(Name: Mona Lisa, DaVinci) (Year: 1496) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1503) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1514) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1520) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected4.trim()))) {
        return false;
      }

      tree.buyArtwork("Mona Lisa, DaVinci", 1503, 1000.0);
      String expected5 = "[(Name: Mona Lisa, DaVinci) (Year: 1496) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1500) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1514) (Cost: $1000.0)]" + "\n"
          + "[(Name: Mona Lisa, DaVinci) (Year: 1520) (Cost: $1000.0)]" + "\n";
      if (!(tree.toString().trim().equals(expected5.trim()))) {
        return false;
      }

      try {
        tree.buyArtwork("Mona Lisa, DaVinci", 15030, 1000.0);
        return false;
      } catch (NoSuchElementException e) {
        if (e.getMessage() == null || e.getMessage().length() == 0) {
          return false;
        }
      } catch (Exception e) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Returns false if any of the tester methods defined in this tester class fails.
   *
   * @return false if any of the tester methods defined in this tester class fails, and true if all
   *         tests pass
   */
  public static boolean runAllTests() {
    return testArtworkCompareToEquals() && testAddArtworkToStringSize() && testLookup()
        && testHeight() && testGetBestArtwork() && testLookupAll() && testBuyArtwork();
  }

  /**
   * Calls the test methods
   *
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testArworkCompareToEquals(): " + testArtworkCompareToEquals());
    System.out.println("testAddArtworkToStringSize(): " + testAddArtworkToStringSize());
    System.out.println("testLookup(): " + testLookup());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testGetBestArtwork(): " + testGetBestArtwork());
    System.out.println("testLookupAll(): " + testLookupAll());
    System.out.println("testBuyArtwork(): " + testBuyArtwork());
    System.out.println("runAllTests(): " + runAllTests());
  }

}
