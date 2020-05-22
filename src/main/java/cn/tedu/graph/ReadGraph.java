package cn.tedu.graph;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;

/**
 * @Author lkh
 */
public class ReadGraph<Graph> {
    public ReadGraph(Graph graph,final String filename){
        URL url=ReadGraph.class.getClassLoader().getResource(filename);
        File file=new File(url.getFile());
        String line;
        int V,E;
        assert (file.isFile());
    }

}
