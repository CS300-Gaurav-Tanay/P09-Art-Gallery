// TODO Complete file header must be added here
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class models the Artwork Gallery implemented as a binary search tree. The search criteria
 * include the year of creation of the artwork, the name of the artwork and its cost.
 *
 * @author TODO add your name(s)
 */
public class ArtGallery {
  // Complete the TODO tags in this source file

  private BSTNode<Artwork> root; // root node of the artwork catalog BST
  private int size; // size of the artwork catalog tree

  /**
   * Checks whether this binary search tree (BST) is empty
   *
   * @return true if this ArtworkGallery is empty, false otherwise
   */
  public boolean isEmpty() {
    // TODO complete the implementation of this method
    return (root == null && size == 0);
  }

  /**
   * Returns the number of artwork pieces stored in this BST.
   *
   * @return the size of this ArtworkGallery
   */
  public int size() {
    // TODO complete the implementation of this method
    return size;
  }

  /**
   * Checks whether this ArtworkGallery contains a Artwork given its name, year, and cost.
   *
   * @param name name of the Artwork to search
   * @param year year of creation of the Artwork to search
   * @param cost cost of the Artwork to search
   * @return true if there is a match with this Artwork in this BST, and false otherwise
   */
  public boolean lookup(String name, int year, double cost) {
    // Hint: create a new artwork with the provided name and year and default cost and use it
    // in the
    // search operation

    // Creating a new artwork to compare against
    Artwork targetArtwork = new Artwork(name, year, cost);

    return lookupHelper(targetArtwork, root);

    // TODO complete the implementation of this method
  }

  /**
   * Recursive helper method to search whether there is a match with a given Artwork in the
   * subtree rooted at current
   *
   * @param target  a reference to a Artwork we are searching for a match in the BST rooted at
   *                current.
   * @param current "root" of the subtree we are checking whether it contains a match to target.
   * @return true if match found and false otherwise
   */
  protected static boolean lookupHelper(Artwork target, BSTNode<Artwork> current) {
    // TODO complete the implementation of this method
    /*
    Is the current node the one I'm looking for?
    Current node is null: done, search failed
    Yes: done, search succeeded
    No: is the query value greater or less than the current node's?
    Greater: search(right child)
    Less: search(left child)
     */
    if (current == null) {
      return false;
    } else if (current.getData().equals(target)) {
      // Artwork is present in the tree
      return true;
    } else {
      // Both the artworks are not equal so using compareTo to see if the target artwork is
      // more than or less than
      if (target.compareTo(current.getData()) > 0) {
        // search right child
        return lookupHelper(target, current.getRight());
      } else {
        return lookupHelper(target, current.getLeft());
      }
    }
  }

  /**
   * Adds a new artwork piece to this ArtworkGallery
   *
   * @param newArtwork a new Artwork to add to this BST (gallery of artworks).
   * @return true if the newArtwork was successfully added to this gallery, and returns false if
   * there is a match with this Artwork already stored in gallery.
   * @throws NullPointerException if newArtwork is null
   */
  public boolean addArtwork(Artwork newArtwork) {
    // TODO complete the implementation of this method
    if (newArtwork == null) {
      throw new NullPointerException("The new artwork to be added is null");
    }

    if (isEmpty()) {
      // root is null so add at root
      root = new BSTNode<Artwork>(newArtwork);
      size++;
      return true;
    }
    if (addArtworkHelper(newArtwork, root)) {
      size++;
      return true;
    }

    return false;
  }

  /**
   * Recursive helper method to add a new Artwork to an ArtworkGallery rooted at current.
   *
   * @param current    The "root" of the subtree we are inserting new Artwork into.
   * @param newArtwork The Artwork to be added to a BST rooted at current.
   * @return true if the newArtwork was successfully added to this ArtworkGallery, false if a
   * match with newArtwork is already present in the subtree rooted at current.
   */
  protected static boolean addArtworkHelper(Artwork newArtwork, BSTNode<Artwork> current) {
    // TODO complete the implementation of this method
    int compare = current.getData().compareTo(newArtwork);

    if (current.getData().equals(newArtwork)) {
      return false;
    }

    if (compare < 0) {
      if (current.getRight() == null) {
        current.setRight(new BSTNode<Artwork>(newArtwork));
        return true;
      } else {
        return addArtworkHelper(newArtwork, current.getRight());
      }
    } else if (compare > 0) {
      if (current.getLeft() == null) {
        // Adding it there
        current.setLeft(new BSTNode<Artwork>(newArtwork));
        return true;
      } else {
        return addArtworkHelper(newArtwork, current.getLeft());
      }
    } else {
      return false;
    }
  }

  /**
   * Gets the recent best Artwork in this BST (meaning the largest artwork in this gallery)
   *
   * @return the best (largest) Artwork (the most recent, highest cost artwork) in this
   * ArtworkGallery, and null if this tree is empty.
   */
  public Artwork getBestArtwork() {
    // TODO implement this method. Feel free to use recursion or iteration to implement this
    //  method

    if (isEmpty()) {
      //  Tree is empty
      return null;
    } else {
      BSTNode<Artwork> currentNode = root;
      while (currentNode.getRight() != null) {
        currentNode = currentNode.getRight();
      }
      return currentNode.getData();
    }
  }

  /**
   * Returns a String representation of all the artwork stored within this BST in the increasing
   * order of year, separated by a newline "\n". For instance
   * <p>
   * "[(Name: Stars, Artist1) (Year: 1988) (Cost: $300.0)]" + "\n" + "[(Name: Sky, Artist1) (Year:
   * 2003) (Cost: $550.0)]" + "\n"
   *
   * @return a String representation of all the artwork stored within this BST sorted in an
   * increasing order with respect to the result of Artwork.compareTo() method (year, cost, name).
   * Returns an empty string "" if this BST is empty.
   */
  @Override public String toString() {
    return toStringHelper(root);
  }

  /**
   * Recursive helper method which returns a String representation of the BST rooted at current.
   * An example of the String representation of the contents of a ArtworkGallery is provided in
   * the description of the above toString() method.
   *
   * @param current reference to the current Artwork within this BST (root of a subtree)
   * @return a String representation of all the artworks stored in the sub-tree rooted at current
   * in increasing order with respect to the result of Artwork.compareTo() method (year, cost,
   * name). Returns an empty String "" if current is null.
   */
  protected static String toStringHelper(BSTNode<Artwork> current) {
    // TODO complete the implementation of this method
    // Declaring local variables
    String result = "";

    if (current == null) {
      return "";
    }


    result += toStringHelper(current.getLeft());
    result += current.getData().toString() + "\n";
    result += toStringHelper(current.getRight());
    return result; // Default return statement added to resolve compiler errors
  }

  /**
   * Computes and returns the height of this BST, counting the number of NODES from root to the
   * deepest leaf.
   *
   * @return the height of this Binary Search Tree
   */
  public int height() {
    // TODO complete the implementation of this method
    if (isEmpty()) {
      return 0;
    } else {
      return (heightHelper(root) + 1);
    }
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at current counting
   * the number of nodes and NOT the number of edges from current to the deepest leaf
   *
   * @param current pointer to the current BSTNode within a ArtworkGallery (root of a subtree)
   * @return height of the subtree rooted at current
   */
  protected static int heightHelper(BSTNode<Artwork> current) {
    // TODO complete the implementation of this method
    if (current == null) {
      return -1;
    }

    int leftHeight = heightHelper(current.getLeft());
    int rightHeight = heightHelper(current.getRight());
    return 1 + Math.max(leftHeight, rightHeight);
  }

  /**
   * Search for all artwork objects created on a given year and have a maximum cost value.
   *
   * @param year creation year of artwork
   * @param cost the maximum cost we would like to search for a artwork
   * @return a list of all the artwork objects whose year equals our lookup year key and maximum
   * cost. If no artwork satisfies the lookup query, this method returns an empty arraylist
   */
  public ArrayList<Artwork> lookupAll(int year, double cost) {
    return lookupAllHelper(year, cost, root);
    // TODO complete the implementation of this method
    // return null; // Default return statement added to resolve compiler errors
  }

  /**
   * Recursive helper method to lookup the list of artworks given their year of creation and a
   * maximum value of cost
   *
   * @param year    the year we would like to search for a artwork
   * @param cost    the maximum cost we would like to search for a artwork
   * @param current "root" of the subtree we are looking for a match to find within it.
   * @return a list of all the artwork objects whose year equals our lookup year key and maximum
   * cost stored in the subtree rooted at current. If no artwork satisfies the lookup query, this
   * method returns an empty arraylist
   */
  protected static ArrayList<Artwork> lookupAllHelper(int year, double cost,
      BSTNode<Artwork> current) {
    ArrayList<Artwork> artworkList = new ArrayList<>();

    // Just Traversing through the ArrayList
    /*
    // base case
    if (root == null) {
      return "";
    }
    // recursive case
    String result = "" + root.data;
    result += traversePre(root.leftChild);
    result += traversePre(root.rightChild);
    return result;
     */

    // base case (which will make the recursion stop)

    if (current != null) {
      if (current.getData().getYear() == year && current.getData().getCost() <= cost) {
        artworkList.add(current.getData());
      }
      artworkList.addAll(lookupAllHelper(year, cost, current.getLeft()));
      artworkList.addAll(lookupAllHelper(year, cost, current.getRight()));
    }

    // TODO complete the implementation of this method
    return artworkList; // Default return statement added to resolve compiler errors
  }

  /**
   * Buy an artwork with the specified name, year and cost. In terms of BST operation, this is
   * equivalent to finding the specific node and deleting it from the tree
   *
   * @param name name of the artwork, artist
   * @param year creation year of artwork
   * @throws NoSuchElementException with a descriptive error message if there is no Artwork found
   *                                with the buying criteria
   */

  public void buyArtwork(String name, int year, double cost) {
    Artwork artwork = new Artwork(name, year, cost);
    root = buyArtworkHelper(artwork, root);
    size--;
  }

  /**
   * Recursive helper method to buy artwork given the name, year and cost. In terms of BST
   * operation, this is equivalent to finding the specific node and deleting it from the tree
   *
   * @param target  a reference to a Artwork we are searching to remove in the BST rooted at
   *                current.
   * @param current "root" of the subtree we are checking whether it contains a match to target.
   * @return the new "root" of the subtree we are checking after trying to remove target
   * @throws NoSuchElementException with a descriptive error message if there is no Artwork found
   *                                with the buying criteria in the BST rooted at current
   */
  protected static BSTNode<Artwork> buyArtworkHelper(Artwork target, BSTNode<Artwork> current) {
    // TODO complete the implementation of this method. Problem decomposition and hints are
    //  provided
    // in the comments below

    // if current == null (empty subtree rooted at current), no match found, throw an exception

    // Compare the target to the data at current and proceed accordingly
    // Recurse on the left or right subtree with respect to the comparison result
    // Make sure to use the output of the recursive call to appropriately set the left or the
    // right child of current accordingly


    // if match with target found, three cases should be considered. Feel free to organize the
    // order
    // of these cases at your choice.

    // current may be a leaf (has no children), set current to null.

    // current may have only one child, set current to that child (whether left or right child)

    // current may have two children,
    // Replace current with a new BSTNode whose data field value is the successor of target in the
    // tree, and having the same left and right children as current. Notice carefully that you
    // cannot
    // set the data of a BSTNode.
    // The successor is the smallest element at the right subtree of current
    // Then, remove the successor from the right subtree. The successor must have up to one child.

    // Make sure to return current (the new root to this subtree) at the end of each case or at
    // the end of the method.

    // if current == null (empty subtree rooted at current), no match found, throw an exception

    if (current == null) {
      throw new NoSuchElementException(target + " not found in this gallery.");
    }

    // Compare the target to the data at current and proceed accordingly
    // Recurse on the left or right subtree with respect to the comparison result
    // Make sure to use the output of the recursive call to appropriately set the left or the
    // right child of current accordingly

    if (target.compareTo(current.getData()) < 0) {
      current.setLeft(buyArtworkHelper(target, current.getLeft()));
    } else if (target.compareTo(current.getData()) > 0) {
      current.setRight(buyArtworkHelper(target, current.getRight()));
    }

    // if match with target found, three cases should be considered. Feel free to organize the
    // order
    // of these cases at your choice.

    else {
      // current may be a leaf (has no children), set current to null.
      if (current.getLeft() == null && current.getRight() == null) {
        current = null;
      }

      // current may have only one child, set current to that child (whether left or right child)
      else if (current.getLeft() == null && current.getRight() != null) {
        // current.setRight(current.getRight());
        return current.getRight();
      } else if (current.getLeft() != null && current.getRight() == null) {
        // current.setLeft(current.getLeft());
        return current.getLeft();
      }

      // current may have two children,
      else if (current.getRight() != null && current.getLeft() != null) {
        BSTNode<Artwork> theNextOne = new BSTNode<Artwork>(getSuccessor(current),
            current.getLeft(), current.getRight());
        current = theNextOne;
        current.setRight(buyArtworkHelper(current.getData(), current.getRight()));
      }
      // Replace current with a new BSTNode whose data field value is the successor of target
      // in the
      // tree, and having the same left and right children as current. Notice carefully that you
      // cannot set the data of a BSTNode.
      // The successor is the smallest element at the right subtree of current
      // Then, remove the successor from the right subtree. The successor must have up to one
      // child.
    }

    // Make sure to return current (the new root to this subtree) at the end of each case or at
    // the end of the method.
    return current;
  }

  /**
   * Helper method to find the successor of a node while performing a delete operation
   * (buyArtwork) The successor is defined as the smallest key in the right subtree. We assume by
   * default that node is not null
   *
   * @param node node whose successor is to be found in the tree
   * @return return the key of the successor node
   */
  protected static Artwork getSuccessor(BSTNode<Artwork> node) {
    // TODO complete the implementation of this method
    BSTNode<Artwork> currNode = node.getRight();

    while (currNode.getLeft() != null) {
      currNode = currNode.getLeft();
    }
    return currNode.getData(); // Default return statement added to resolve compiler errors
  }

  public static void main(String[] args) {
    ArtGallery gallery = new ArtGallery();
    System.out.println("Size: " + gallery.size() + " Height: " + gallery.height() + "\nGallery:");
    System.out.println(gallery);
    gallery.addArtwork(new Artwork("Guernica, Picasso", 1937, 3000));
    gallery.addArtwork(new Artwork("Starry Night, Van Gogh", 1889, 2000));
    System.out.println("==============================================================");
    System.out.println("Size: " + gallery.size() + " Height: " + gallery.height() + "\nGallery:");
    System.out.println(gallery);

    gallery.addArtwork(new Artwork("NightHawks, Hopper", 1942, 4000));
    gallery.addArtwork(new Artwork("Mona Lisa, DaVinci", 1503, 1000));
    gallery.addArtwork(new Artwork("Whistler, Abbott", 1871, 5000));
    gallery.addArtwork(new Artwork("Amazone, Tsalapatanis", 2021, 6080));

    System.out.println("==============================================================");
    System.out.println("Size: " + gallery.size() + " Height: " + gallery.height() + "\nGallery:");
    System.out.println(gallery);
    gallery.addArtwork(new Artwork("Persistence of Memory, Dali", 1931, 7000));
    gallery.addArtwork(new Artwork("Der Schrei, Silber", 2019, 12160));
    gallery.addArtwork(new Artwork("Gothic, Wood", 1930, 6000));
    gallery.addArtwork(new Artwork("For gourmets, Tuzhilkina", 2021, 1280));
    gallery.addArtwork(new Artwork("Cantabrico, Torices", 2021, 3870));

    System.out.println("==============================================================");
    System.out.println("Size: " + gallery.size() + " Height: " + gallery.height() + "\nGallery:");
    System.out.println(gallery);
    try {
      System.out.println(
          "This gallery contains (Mona Lisa, DaVinci, 1503, 1000): " + gallery.lookup(
              "Mona Lisa, DaVinci", 1503, 1000));
      System.out.println(
          "This gallery contains (Whistler, Abbott, 1871, 5000): " + gallery.lookup(
              "Whistler, Abbott", 1871, 5000));
      System.out.println();
      System.out.println(
          "This gallery contains (Chaplin, Brainwash\", 2020, 9090): " + gallery.lookup(
              "Chaplin, Brainwash", 2020, 9090));
      System.out.println();
      System.out.println("Best (greatest) artwork: " + gallery.getBestArtwork());
      System.out.println();
      System.out.println(
          "Lookup query: search for the artworks of 2021 whose costs do not exceed $5000.00:");
      System.out.println(gallery.lookupAll(2021, 5000));
      System.out.println();
      System.out.println(
          "Lookup query: search for the artworks of 2021 whose costs do not exceed $10000.00:");
      System.out.println(gallery.lookupAll(2021, 10000));
      System.out.println();
      System.out.println("Buy \"Der Schrei, Silber\", 2019, 12160:");
      gallery.buyArtwork("Der Schrei, Silber", 2019, 12160);
      System.out.println(
          "Size: " + gallery.size() + " Height: " + gallery.height() + "\nGallery:");
      System.out.println(gallery);
      System.out.println();
      System.out.println("Buy \"Mona Lisa, DaVinci\", 1503, 1000:");
      gallery.buyArtwork("Mona Lisa, DaVinci", 1503, 1000);
      System.out.println(
          "Size: " + gallery.size() + " Height: " + gallery.height() + "\nGallery:");
      System.out.println(gallery);
      System.out.println();
      System.out.println("Buy \"Guernica, Picasso\", 1937, 3000:");
      gallery.buyArtwork("Guernica, Picasso", 1937, 3000);
      System.out.println(
          "Size: " + gallery.size() + " Height: " + gallery.height() + "\nGallery:");
      System.out.println(gallery);
      System.out.println();
      System.out.println("Buy \"Mona Lisa, DaVinci\", 1503, 1000:");
      gallery.buyArtwork("Mona Lisa, DaVinci", 1503, 1000);
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
  }
}
