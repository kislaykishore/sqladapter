/**
 * 
 */
package org.kishore.prog;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.kishore.parser.CaseChangingCharStream;
import org.kishore.parser.MyTSqlParserVisitor;
import org.kishore.parser.TSqlLexer;
import org.kishore.parser.TSqlParser;
import org.kishore.parser.TSqlParser.Select_statementContext;
import org.kishore.parser.TSqlParser.Sql_clausesContext;
import org.kishore.parser.TSqlParser.Tsql_fileContext;
import org.kishore.parser.TSqlParserVisitor;

/**
 * @author kislay
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "SELECT isnull(P, 'EMPTY') from abcd A WITH (INDEX(ABC_Def)) where A.TE = 'pq   R'";
		CharStream stream = new CaseChangingCharStream(CharStreams.fromString(sql), true);
		TSqlLexer lexer = new TSqlLexer(stream);
		 
	    // Get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	 
	    // Pass the tokens to the parser
	    TSqlParser parser = new TSqlParser(tokens);
	    //parser.setBuildParseTree(true);
	    Tsql_fileContext file = parser.tsql_file();
	    
	    MyTSqlParserVisitor visitor = new MyTSqlParserVisitor();
	    String str = visitor.visit(file);
	    System.out.println(str);
	 
	    // Specify our entry point
	    //Sql_clausesContext sqlClausesContext = parser.sql_clauses();
	 
	    // Walk it and attach our listener
	    //ParseTreeWalker walker = new ParseTreeWalker();
	    //TSqlParserBaseListener listener = new TSqlParserBaseListener();
	    //walker.walk(listener, selectStatement);
//	    AntlrDrinkListener listener = new AntlrDrinkListener();
//	    walker.walk(listener, drinkSentenceContext);

	}

}
