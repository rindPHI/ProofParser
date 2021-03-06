package de.tud.cs.se.ds.proofrenderer.model;

import java.util.HashMap;
import java.util.Set;

public class ProofTree implements ProofTreeModelElement {
    private Set<Usepackage> usePackages = null;
    private Set<TexInput> latexInputs = null;
    private HashMap<String, OperatorDefinition> opdefs = null;
    private HashMap<String, MacroDefinition> macrodefs = null;
    private SubTree subtree = null;

    public ProofTree(Set<Usepackage> usePackages, Set<TexInput> latexInputs,
            HashMap<String, MacroDefinition> macrodefs, HashMap<String, OperatorDefinition> opdefs, SubTree subtree) {
        this.usePackages = usePackages;
        this.latexInputs = latexInputs;
        this.macrodefs = macrodefs;
        this.opdefs = opdefs;
        this.subtree = subtree;
    }

    public Set<Usepackage> getUsePackages() {
        return usePackages;
    }

    public void setUsePackages(Set<Usepackage> usePackages) {
        this.usePackages = usePackages;
    }

    public Set<TexInput> getLatexInputs() {
        return latexInputs;
    }

    public void setLatexInputs(Set<TexInput> latexInputs) {
        this.latexInputs = latexInputs;
    }

    public HashMap<String, MacroDefinition> getMacrodefs() {
        return macrodefs;
    }

    public void setMacrodefs(HashMap<String, MacroDefinition> macrodefs) {
        this.macrodefs = macrodefs;
    }

    public MacroDefinition getMacrodef(String name) {
        return macrodefs.get(name);
    }


    public HashMap<String, OperatorDefinition> getOpdefs() {
        return opdefs;
    }

    public OperatorDefinition getOpdef(String name) {
        return opdefs.get(name);
    }

    public void setOpdefs(HashMap<String, OperatorDefinition> opdefs) {
        this.opdefs = opdefs;
    }

    public SubTree getSubtree() {
        return subtree;
    }

    public void setSubtree(SubTree subtree) {
        this.subtree = subtree;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        for (Usepackage usepkg : usePackages) {
            sb.append(usepkg.toString()).append("\n");
        }

        for (String macrodef : macrodefs.keySet()) {
            sb.append(getMacrodef(macrodef).toString()).append("\n");
        }

        for (String opdef : opdefs.keySet()) {
            sb.append(getOpdef(opdef).toString()).append("\n");
        }

        sb.append("\n(proof ");
        sb.append(subtree.toString());
        sb.append(")");

        return sb.toString();
    }
}
