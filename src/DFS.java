import java.util.ArrayList;
import java.util.LinkedList;

public class DFS {
	public String v;
    public DFS parent;
    public ArrayList<DFS> adj = new ArrayList<DFS>();
    public int start;
    public int end;
    DFS(String vertex){
        v = vertex;
        parent = null;
        start = 0;
        end = 0;
        
    }
    
    public void setNeighbor(DFS n){
        adj.add(n);
    }
    
    public static void DFS_visit(DFS u, LinkedList<DFS> q){
    	time++;
    	u.start = time;
    	boolean loop = false;
    	for(DFS v :u.adj ) {
    		if (v.parent == null) {
    			v.parent = u;
    			DFS_visit(v, q);
    		}
    		else if(v.start != 0 && v.end == 0){
    			System.out.println("Cycle detected, topological sort is impossible");	
    			loop = true;
    			break;
    		
    		}
    	}
    	time++;
    	u.end = time;
    	if(loop==false) {
    		q.add(u);
    	}

    	
    }
    public static void DFS1(ArrayList<DFS> x) {
    	LinkedList<DFS> q = new LinkedList<>();

    	boolean loop = true;
    	for(DFS y: x) {
    		if (y.parent==null) {
    			y.parent = y;
    			DFS_visit(y, q);
    		}  		
  
        	}
    	if(q.size() < x.size()) {
    		loop = false;
    	}
    	if(loop==true) {
    		for(DFS z: q) {
    			System.out.println("Topological order: " + z.v);
        		System.out.println("Start time: "+z.start);
        		System.out.println("End time: "+z.end);
    		}
    	}
    		
    	}
  
    
  
    
    
    
    
    static int time = 0;
    public static void main(String args[])
    {
    	System.out.println("Part 1: ");
    	ArrayList<DFS> graph = new ArrayList<DFS>();
    	ArrayList<DFS> graph2 = new ArrayList<DFS>();

    	DFS a = new DFS("a");
    	DFS b = new DFS("b");
    	DFS c = new DFS("c");
    	DFS d = new DFS("d");
    	DFS e = new DFS("e");
    	DFS f = new DFS("f");
    	DFS g = new DFS("g");
    	
    	DFS A = new DFS("A");
    	DFS B = new DFS("B");
    	DFS C = new DFS("C");
    	DFS D = new DFS("D");
    	DFS E = new DFS("E");
    	DFS F = new DFS("F");
    	
    	graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        graph.add(f);
        graph.add(g);
        
    	graph2.add(A);
        graph2.add(B);
        graph2.add(C);
        graph2.add(D);
        graph2.add(E);
        graph2.add(F);
        
        a.setNeighbor(b);
        a.setNeighbor(c);
        a.setNeighbor(d);
        b.setNeighbor(d);
        c.setNeighbor(d);
        d.setNeighbor(e);
        e.setNeighbor(g);
        f.setNeighbor(e);

        A.setNeighbor(B);
        A.setNeighbor(C);
        B.setNeighbor(C);
        B.setNeighbor(D);
        B.setNeighbor(E);
        C.setNeighbor(E);
        D.setNeighbor(F);
        E.setNeighbor(B);
        E.setNeighbor(D);
        F.setNeighbor(E);
        
        DFS1(graph);
        System.out.println();
        time = 0;
        DFS1(graph2);
        
        
        
        
        
        
        
    }
    
    

}
