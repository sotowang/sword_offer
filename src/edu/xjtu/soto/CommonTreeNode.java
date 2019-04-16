package edu.xjtu.soto;

import java.util.ArrayList;
import java.util.List;

public class CommonTreeNode {
    public List<CommonTreeNode> children = new ArrayList<>();
    public String val;

    public CommonTreeNode(String val) {
        this.val = val;
    }
}
