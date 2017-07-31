package dnasplicing;

public class LinkedDnaStrand implements DnaStrand {

	private DnaSequenceNode top = null;
	private int nodeCount = 0;
	private int appendCount = 0;

	// Adds a new DnaSequenceNode to the end of the list
	public LinkedDnaStrand(String dnaSequence) {
		DnaSequenceNode dnasequencenode = new DnaSequenceNode(dnaSequence);
		if (top == null)
			top = dnasequencenode; // This is the first node added
		else {
			DnaSequenceNode cursor = top; // Cursor points to the top of the
											// list
			while (cursor.next != null) // Make cursor point to last item
				cursor = cursor.next;
			cursor.next = dnasequencenode; // adds new node to end of list
			cursor.next.previous = cursor; // points new node back to previous
											// node
		}
		nodeCount++;
	}

	public String toString() { // returns the entire DNA sequence
		StringBuilder sb = new StringBuilder(); // whole dna sequence
		DnaSequenceNode cursor = top; // cursor points to first node
		while (cursor != null) {
			sb.append(cursor.dnaSequence); // sb appends next dna sequence onto
											// it
			cursor = cursor.next;
		}
		return sb.toString();
	}

	@Override
	public long getNucleotideCount() {
		int nucleoCount = toString().length(); // get the length of the dna
												// sequence
		return nucleoCount;
	}

	@Override
	public void append(String dnaSequence) { // adds a DnaSequenceNode to the
												// end of the list
		DnaSequenceNode dnasequencenode = new DnaSequenceNode(dnaSequence);
		if (top == null) {
			top = dnasequencenode;
		} else {
			DnaSequenceNode cursor = top;
			while (cursor.next != null)
				cursor = cursor.next;
			cursor.next = dnasequencenode;
			cursor.next.previous = cursor;
			appendCount++;
		}
		nodeCount++;
	}

	@Override
	public DnaStrand cutSplice(String enzyme, String splicee) {
		 DnaStrand newStrand = null;
		 String originalDna = this.toString();
		 String newDna = originalDna.replaceAll(enzyme, splicee);
		 // splits up DNA before and after splice
		 String[] spliceeSplit = newDna.split(splicee);
		
		 if (newDna.startsWith(splicee)) { // the beginning of the strand
		 newStrand = new LinkedDnaStrand(splicee);
		 } else {
		 newStrand = new LinkedDnaStrand(spliceeSplit[0]);
		 newStrand.append(splicee);
		 }
		
		 for (int i = 1; i < spliceeSplit.length - 1; i++) { // middle of strand
		 newStrand.append(spliceeSplit[i]);
		 newStrand.append(splicee);
		 }
		
		 newStrand.append(spliceeSplit[spliceeSplit.length - 1]); // end of strand
		
		 if (newDna.endsWith(splicee)) { // possible end of strand
		 newStrand.append(splicee);
		 }
		
		 return newStrand;
	}

	@Override
	public DnaStrand createReversedDnaStrand() {
		StringBuilder strand = new StringBuilder();
		DnaStrand reverse = null;
		for (int i = this.toString().length() - 1; i >= 0; i--) // assign characters in reverse
			strand.append(this.toString().charAt(i));
		reverse = new LinkedDnaStrand(strand.toString());
		return reverse;
	}

	@Override
	public int getAppendCount() {
		return appendCount;
	}

	@Override
	public DnaSequenceNode getFirstNode() {
		return top;
	}

	@Override
	public int getNodeCount() {
		return nodeCount;
	}

}
