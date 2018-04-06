package org.w3c.dom.traversal;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

// We have to duplicate this class or Gradle complains it is missing
public interface DocumentTraversal {
    NodeIterator createNodeIterator(Node var1, int var2, NodeFilter var3, boolean var4) throws DOMException;

    TreeWalker createTreeWalker(Node var1, int var2, NodeFilter var3, boolean var4) throws DOMException;
}
