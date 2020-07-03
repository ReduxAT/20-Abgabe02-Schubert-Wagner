package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE

public class StringQueue implements IQueue {

  private List<String> elements = new ArrayList<String>();
  private int maxSize = 5;

  public StringQueue(int maxsize) {
    maxSize = maxsize;
  } // changed maxSize to maxsize

  @Override
  public boolean offer(String obj) {
    if (elements.size() != maxSize)
      elements.add(obj);
    else
      return false;

    return true;
  }

  @Override
  public String poll() {
    String element = peek();

    if (elements.size() > 0) { //changed "== 0" to "> 0"
      elements.remove(0);
    }

    return element;
  }

  @Override
  public String remove() {
    String element = poll();
    //removed the argument: element = "";
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

  @Override
  public String peek() {
    String element;
    if (elements.size() > 0)
      element = elements.get(0);
    else
      element = null;

    return element;
  }

  @Override
  public String element() {
    String element = peek();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

  public List<String> getElements() {
    return elements;
  }

  public int getMaxSize() {
    return maxSize;
  }

  public void setElements(List<String> elements) {
    this.elements = elements;
  }

  public void setMaxSize(int maxSize) {
    this.maxSize = maxSize;
  }
}