
package lineeditor;

import java.util.* ;

/*
class G{

  static ICEInputStream sIn = null;
  static void Init() throws Throwable{
    sIn = new ICEInputStream();
  }
  static String Big5(String str) throws Throwable{
    return new String(str.getBytes("big5"), "IS08859_1") ;
  } // Big5
  static void CYPrint(String str) throws Throwable{
    byte[] binary=str.getBytes("Big5") ;
    System.out.write(binary,0,binary.length) ;
  } // CYPrint()

} // class G
*/

class Buffer {
  protected Vector<String> mpArticle = new Vector<String>() ;
  protected String mName = null ;
  protected int mCurrentLine = 0 ;
  
  
  void Add()throws Throwable {
    
    // String line = G.sIn.ReadInputLine();
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    while ( ! line.equals(".") ) {
      
      mpArticle.add(line);
      // line = G.sIn.ReadInputLine();
      line = scanner.nextLine();
    } // while
    mCurrentLine = mpArticle.size();
    System.out.println(mCurrentLine ) ;
     
  } // Add
  
  void Add( int editLine ) throws Throwable {
    
    if (  editLine > mpArticle.size() )
      System.out.println( "Error : Line number out of range ! Please try again.");
    else {
      mCurrentLine = editLine ;
      Scanner scanner = new Scanner(System.in);
      String line = scanner.nextLine();
      // String line = G.sIn.ReadInputLine();
      while ( ! line.equals(".")) {
        mpArticle.add(mCurrentLine, line);
        mCurrentLine++ ;
        line = scanner.nextLine();
        // line = G.sIn.ReadInputLine();
      } // while
    } // else
    System.out.println(mCurrentLine ) ;
  } // Add()
  
  void Insert() throws Throwable {
    int time = 0 ;
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    // String line = G.sIn.ReadInputLine() ;
    while ( ! line.equals(".") ) {
      if ( mpArticle.size() == 0 ) {
        mpArticle.add(line);
        mCurrentLine = mpArticle.size();
      } // if
      else {
        if ( time == 0 )
          mpArticle.insertElementAt(line, mCurrentLine - 1 );
        else {
          mpArticle.add(mCurrentLine, line);
          mCurrentLine++ ;
        } // else
      } // else
      time++ ;
      line = scanner.nextLine();
      // line = G.sIn.ReadInputLine() ;
    } // while
    System.out.println(mCurrentLine ) ;
  } // Insert()
  
  void Insert( int editLine ) throws Throwable {
    int time = 0 ;
    if (  editLine > mpArticle.size() )
      System.out.println( "Error : Line number out of range ! Please try again.");
    else {
      mCurrentLine = editLine ;
      //String line = G.sIn.ReadInputLine();
      Scanner scanner = new Scanner(System.in);
      String line = scanner.nextLine();
      while ( ! line.equals(".")) {
        if ( time == 0 )
          mpArticle.insertElementAt(line, mCurrentLine - 1 );
        else {
          mpArticle.add(mCurrentLine, line);
          mCurrentLine++ ;
        } // else
        time++ ;
        line = scanner.nextLine(); //line = G.sIn.ReadInputLine();
      } // while
    } // else
    System.out.println(mCurrentLine ) ;
  } // Insert()
  
  
  void Change() throws Throwable {
    int time = 0 ;
    if ( mpArticle.size() == 0 )
      System.out.println( "Error : There is no data! Please try again.") ;
    else {
      // String line = G.sIn.ReadInputLine();
      Scanner scanner = new Scanner(System.in);
      String line = scanner.nextLine();
      while ( ! line.equals(".")) {
        if ( time == 0 )
          mpArticle.set(mCurrentLine - 1 , line ) ;
        else {
          mpArticle.add(mCurrentLine, line);
          mCurrentLine++ ;
        } // else
         time++ ;
         line = scanner.nextLine(); //line = G.sIn.ReadInputLine();
       } // while
    } // else
    System.out.println(mCurrentLine ) ;
  } // Change()
  
  
  
  void Change( int editLine ) throws Throwable {
    int time = 0 ;
    if (  editLine > mpArticle.size() )
      System.out.println( "Error : Line number out of range ! Please try again.");
    else {
     //  mCurrentLine = editLine ;
      //String line = G.sIn.ReadInputLine();
      Scanner scanner = new Scanner(System.in);
      String line = scanner.nextLine();
      while ( ! line.equals(".")) {
        /*
        if ( line.trim().isEmpty() )
          Delete(mCurrentLine);
    */
        if ( time == 0 ) {
          mpArticle.set(editLine - 1 , line ) ;
        } // if
        else {
          mpArticle.add(editLine, line);
          // mCurrentLine++ ;
        } // else
        
        time++ ;
        line = scanner.nextLine(); //line = G.sIn.ReadInputLine();
      } // while
    } // else
    System.out.println(mCurrentLine) ;
  } // Change()
  
  
  
  void Delete() throws Throwable {
    if ( mpArticle.size() == 0 )
       System.out.println( "Error : There is no data! Please try again.") ;
    else {
      if ( mCurrentLine == mpArticle.size() )  { // ?????????????????????????????????
        mpArticle.remove(mCurrentLine - 1 ) ;
        mCurrentLine = mpArticle.size();
      } // if
      else
        mpArticle.remove(mCurrentLine - 1 ) ;
    } // else
    System.out.println(mCurrentLine) ;
  } // Delete()
  
  
  void Delete( int editLine ) throws Throwable {
    if (  editLine > mpArticle.size() )
      System.out.println( "Error : Line number out of range ! Please try again.");
    else {
      
      if ( editLine == mpArticle.size() ) {
        mpArticle.remove(editLine - 1 ) ;
        if ( mCurrentLine == editLine )
          mCurrentLine = mpArticle.size();
      } // if
      else
        mpArticle.remove(editLine - 1 ) ;
    } // else
    System.out.println(mCurrentLine) ;
  } // Delete()
  
  
  
  void PrintALine() throws Throwable {
    if ( mpArticle.size() == 0 )
      System.out.println( "Error : There is no data ! Please try again.");
    else 
      System.out.println( mpArticle.get(mCurrentLine - 1 ));
    
    System.out.println(mCurrentLine) ;
  } // PrintALine
  
  
  void PrintALine( int editLine ) throws Throwable {
      if (  editLine > mpArticle.size() )
        System.out.println( "Error : Line number out of range ! Please try again.");
      else 
        System.out.println( mpArticle.get(editLine-1)) ;
  } // PrintALine
  
  void PrintAll() throws Throwable {
    for ( int i = 0 ; i < mpArticle.size() ; i++ )
      System.out.println( mpArticle.get(i));
  } // PrintAll()
  
  
  void PrintAndChange( int line ) throws Throwable {
    
    if ( line > 0  && line <= mpArticle.size() ) {
      mCurrentLine = line ;
      System.out.println( mCurrentLine +  " : "  +  mpArticle.get(mCurrentLine - 1 ) ) ;
    } // if
    else if ( line == 0 )
      System.out.println( "Error : There is no data ! Please try again." );
    else if ( line  >  mpArticle.size() )
      System.out.println( "Error : Line number out of range ! Please try again." );

  } // PrintAndChange()
  
} // class Buffer

class Editor extends Buffer {
  static Vector<Buffer> sBuffer = new Vector<Buffer>() ;
  static Buffer sCurrentBuffer = new Buffer();
  
  static void Start() throws Throwable {
    sCurrentBuffer = new Buffer();
    sBuffer.add(sCurrentBuffer);
    sCurrentBuffer.mName = "Buffer-" + ( sBuffer.size() - 1 ) ;
  } // Start()
  
  
  static void NewBuffer() throws Throwable {
    sCurrentBuffer = new Buffer();
    sBuffer.add(sCurrentBuffer);
    sCurrentBuffer.mName = "Buffer-" + ( sBuffer.size() - 1 ) ;
  } // NewBuffer
  
    static void NewBuffer( String name ) throws Throwable {
      sCurrentBuffer = new Buffer();
      sBuffer.add(sCurrentBuffer);
      sCurrentBuffer.mName = name ;
  } // NewBuffer
  
    static void ChangeBuffer( String name ) throws Throwable {
      boolean hasName = false ;
      for ( int i = 0 ; i < sBuffer.size() &&  ! hasName ; i++ ) {
        if ( sBuffer.get(i).mName.equals(name) ) {
          hasName = true ;
          sCurrentBuffer = sBuffer.get(i) ;
        } // if
      } // for
      
      if ( ! hasName )
        System.out.println( " Error : There is no such buffer! Please try again." );
    } // ChangeBuffer
  
  static void ListAllBuffer() throws Throwable {
    for ( int i = 0 ; i < sBuffer.size() ; i++ )
      System.out.println( sBuffer.get(i).mName +  " " + sBuffer.get(i).mpArticle.size());
  } // ListAllBuffer()
  
} // class Editor


public class LineEditor {

  static char sWay ;
  static int sEditLine = 0 ;
  static int sCase = 0 ;
  
  static void Enter() throws Throwable {
    Scanner scanner = new Scanner(System.in);
    char enter = (char) System.in.read();; // char enter = G.sIn.ReadChar();
    while( enter != '\n' )
      enter = (char) System.in.read();; // enter = G.sIn.ReadChar();
  } // Enter()
  
  static boolean IsWhiteSpace( char ch ) throws Throwable {
    if ( ch == ' ' || ch == '\n' || ch == '\t' )
      return true ;
    else
      return false ;
    
  } // IsWhiteSpace
 
    static void SkipSpaceAndTab() throws Throwable {
    while ( sWay == ' '  || sWay == '\t' ) {
        Scanner scanner = new Scanner(System.in);
        sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
    } 
      
  } // SkipSpaceAndTab()
  
  
  static void SkipAllWhiteSpace() throws Throwable {
    while ( sWay == ' ' || sWay == '\n' || sWay == '\t' ) {
        Scanner scanner = new Scanner(System.in);
        sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
    }
  } // SkipAllWhiteSpace()

   static boolean IsDigit( char ch ) throws Throwable {
     if ( ch >= '0' && ch <= '9')
       return true ;
     else
       return false ;
   } // IsDigit()
   
   static void FirstIsDigit() throws Throwable {
     sEditLine = 0 ;
     while ( IsDigit( sWay ) ) {
       int num = sWay - '0' ;
       sEditLine = sEditLine * 10 + num ;
       Scanner scanner = new Scanner(System.in);
       sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
       if ( sWay == ' ' || sWay == '\t' )
         SkipSpaceAndTab() ;    
     } // while
     
     System.out.println( sEditLine ) ;
     if ( sWay == '\n' ) { // ???????????? 
       // sCase = 1 ;
       Editor.sCurrentBuffer.PrintAndChange(sEditLine);
    } // if
     else if ( sWay == 'a' ) {
       Enter() ; 
       Editor.sCurrentBuffer.Add(sEditLine);
     } // else if 
     else if ( sWay == 'i' ) {
       Enter();
       Editor.sCurrentBuffer.Insert(sEditLine);
     } // else if
      else if ( sWay == 'c' ) {
       Enter();
       Editor.sCurrentBuffer.Change(sEditLine);
     } // else if
      else if ( sWay == 'd' ) {
       Enter();
       Editor.sCurrentBuffer.Delete(sEditLine);
     } // else if    
      else if ( sWay == 'p' ) {
       Enter();
       Editor.sCurrentBuffer.PrintALine(sEditLine);
     } // else if    
      else {  // 23 HOW
         Enter();
          Editor.sCurrentBuffer.PrintAndChange(sEditLine);
         System.out.println( " Unprocessable command! Please try again.") ;
      } // else
     
   } // FirstIsDigit()
   
   
   static void FirstIsMoney() throws Throwable {
     Scanner scanner = new Scanner(System.in);
     sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
     
     while ( sWay ==  ' ' || sWay == '\t' ) 
       sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();

     
     if ( sWay ==  '\n' )   // ??????$
       Editor.sCurrentBuffer.PrintAndChange(Editor.sCurrentBuffer.mpArticle.size() );
     else if ( sWay == 'a' ) {
       Enter();
       Editor.sCurrentBuffer.Add();
     } // else if
      else if ( sWay == 'i' ) {
       Enter();
       Editor.sCurrentBuffer.Insert(Editor.sCurrentBuffer.mpArticle.size());
     } // else if
      else if ( sWay == 'c' ) {
       Enter();
       Editor.sCurrentBuffer.Change(Editor.sCurrentBuffer.mpArticle.size());
     } // else if
      else if ( sWay == 'd' ) {
       Enter();
       Editor.sCurrentBuffer.Delete(Editor.sCurrentBuffer.mpArticle.size());
     } // else if    
      else if ( sWay == 'p' ) {
       Enter();
       Editor.sCurrentBuffer.PrintALine(Editor.sCurrentBuffer.mpArticle.size());
     } // else if    
     else {
       Enter();
       Editor.sCurrentBuffer.PrintAndChange(Editor.sCurrentBuffer.mpArticle.size() );
       System.out.println( " Unprocessable command! Please try again.") ;
     } // else
   } // FirstIsMoney
   
   
   static void FirstIsDot() throws Throwable {
     Scanner scanner = new Scanner(System.in);
     sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
     while ( sWay == ' ' || sWay == '\t' )
       sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
     if ( sWay == '\n' )  // ??????.
       Editor.sCurrentBuffer.PrintAndChange(Editor.sCurrentBuffer.mCurrentLine);
     else if ( sWay == 'a' ) {
       Enter();
       Editor.sCurrentBuffer.Add(Editor.sCurrentBuffer.mCurrentLine );
     } // else if
      else if ( sWay == 'i' ) {
       Enter();
       Editor.sCurrentBuffer.Insert();
     } // else if
      else if ( sWay == 'c' ) {
       Enter();
       Editor.sCurrentBuffer.Change();
     } // else if
      else if ( sWay == 'd' ) {
       Enter();
       Editor.sCurrentBuffer.Delete();
     } // else if    
      else if ( sWay == 'p' ) {
       Enter();
       Editor.sCurrentBuffer.PrintALine();
     } // else if
     else {  // . How are you ???????????????.
       Enter();
       Editor.sCurrentBuffer.PrintAndChange(Editor.sCurrentBuffer.mCurrentLine);
       System.out.println( " Unprocessable command! Please try again.") ;
     } // else
   } // FirstIsDot()
   
   static void FirstIsaOriOrdOrp() throws Throwable {  // a i d p ??????????????????
     Enter();
     if ( sWay == 'a' )
       Editor.sCurrentBuffer.Add();
     else if ( sWay == 'i' )
       Editor.sCurrentBuffer.Insert();
     else if ( sWay == 'd')
       Editor.sCurrentBuffer.Delete();
     else if ( sWay == 'p' )
       Editor.sCurrentBuffer.PrintALine();
   } // FirstIsaOriOrdOrp
   
   
   static void FirstIsPercent() throws Throwable {
     Scanner scanner = new Scanner(System.in);
     sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
     
     while ( sWay == ' ' || sWay == '\t' || sWay == '\n' )
       sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
     if ( sWay == 'p' ) {
       Enter();
       Editor.sCurrentBuffer.PrintAll();
     } // if
     else {
       Enter();
       System.out.println( " Unprocessable command! Please try again.") ;
     } // else
   } // FirstIsPercent()
   
   
   static boolean IsaORiOrdOrp( char ch ) throws Throwable {
     if ( ch == 'a' || ch == 'i'  || ch == 'd' || ch == 'p'  )
       return true ;
     else
       return false ;
   } // IsaORiOrdOrp()
   
   static void ChangeLineOrBuffer() throws Throwable {   // c
     Scanner scanner = new Scanner(System.in);
     sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
     while ( sWay == ' ' || sWay == '\t' ) 
       sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
       
     if ( sWay ==  '\n' ) // c
       Editor.sCurrentBuffer.Change();
     else if ( sWay == 'b' ){ // cb
       
       sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
       if ( sWay != ' ' && sWay != '\t' && sWay != '\n' ) {           // cbggg
         Enter();
         System.out.println( " Unprocessable command! Please try again.") ;
       } // if
       else {   // cb name
         while ( sWay == ' ' || sWay == '\t' || sWay == '\n' )
            sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
         char name[] = new char[100] ;
         int j = 0 ;
         while ( sWay != '\n' ) {
           name[j] = sWay ;
           j++ ;
           sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
            while ( sWay == ' ' || sWay == '\t'  )
              sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
         } // while
         
         String newName =  String.valueOf(name).trim() ;
         // System.out.println( newName + "66" ) ;
         Editor.ChangeBuffer(newName);
       } // else

     } // else if 
     else {  // c How are you ??????c
       Enter();
       Editor.sCurrentBuffer.Change();
     } // else
   } // ChangeLineOrBuffer()
   
   
   static void  List() throws Throwable {
     Scanner scanner = new Scanner(System.in);
     sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
     while ( sWay == ' ' || sWay == '\t' || sWay == '\n' ) 
       sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();

     if ( sWay == 'b' ) {
       Enter();
       Editor.ListAllBuffer();
     } // if
     else {
       Enter();
       System.out.println( " Unprocessable command! Please try again." );
     } // else

   } // List()
   
   static void CurrentBuffer() throws Throwable {          // b

     Scanner scanner = new Scanner(System.in);
     sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
     if ( sWay != ' ' && sWay != '\t' ) {   // b ????????????buffer???????????????
       if ( sWay != '\n' )
         Enter();
       System.out.println( Editor.sCurrentBuffer.mName + " " +  Editor.sCurrentBuffer.mpArticle.size() );
     } // if
     else {  
       sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
       while ( sWay == ' ' || sWay == '\t' )
         sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
       if ( sWay == '\n' )
          System.out.println( Editor.sCurrentBuffer.mName + " " +  Editor.sCurrentBuffer.mpArticle.size() );
       else {
         char name[] = new char[100];
         int j = 0 ;
         while ( sWay != '\n' ) {
           name[j] = sWay ;
           j++;
           sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
           while ( sWay == ' ' || sWay == '\t' )
             sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
         } // while
           String spaceName = String.valueOf(name) ;
           String newName = String.valueOf(name).trim();
           System.out.println( newName + "00" ) ;
           Editor.sCurrentBuffer.mName = newName ;
       } // else

     } // else
   } // CurrentBuffer()
   
   static void ProduceNewBuffer() throws Throwable {   // n ??????
     Scanner scanner = new Scanner(System.in);
     sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
     while( sWay == ' ' || sWay == '\t' || sWay == '\n' ) 
       sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();

      
     if ( sWay != 'b' )
       System.out.println( " Unprocessable command! Please try again." );
     else {  // nb ??? nb name
       sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
       if ( sWay != ' ' && sWay != '\t' ) {    // nb\n nbbbbbbbbbbb
         if ( sWay!= '\n' )
           Enter();
         Editor.NewBuffer();
       } // if
       else {
         while( sWay == ' ' || sWay == '\t'  ) 
            sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
         if ( sWay == '\n' ) // nb 
           Editor.NewBuffer();
         else {    // nb name
           int j = 0 ;
           char name[] = new char[100] ;
           
          
           while ( sWay != '\n' ) {              // ???????????????????????????
             name[j] = sWay ;
             j++ ;
             sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
             while ( sWay == ' ' || sWay == '\t' )
               sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
           } // while
           
           
           // name[0] = sWay ;
           /*
           while ( name[j] != ' ' && name[j] != '\t' && name[j] != '\n' ) {        // ???????????????????????????
             j++ ;
             name[j] = G.sIn.ReadChar();
           } // while
          if ( name[j] != '\n' ) 
             Enter();   
             */
           String spaceName = String.valueOf(name) ;
           String newName = String.valueOf(name).trim();
           // System.out.println( newName + "00" ) ;
           Editor.NewBuffer(newName); 
         } // else
       } // else
     } // else
     
   } // ProduceNewBuffer()
   
   
  public static void main(String[] args) throws Throwable{
  
    //G.Init();
    Editor.Start();
    System.out.println("Welcome to CYICE Line Editor...");
    //G.CYPrint("Welcome to CYICE Line Editor..." + "\n" ) ;
    System.out.print("> ") ;
    Scanner scanner = new Scanner(System.in);
    sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
    if ( IsWhiteSpace( sWay) ) 
      SkipAllWhiteSpace();   // ????????????sWay??????????????????white space ???
    
    while ( sWay != 'q' ) {
      sCase = 0 ;
      if ( IsDigit( sWay ) )    // ??????????????????
        FirstIsDigit() ;
      else if ( sWay == '$'  )    // ????????????
        FirstIsMoney() ;
      else if ( sWay == '.' )    // ????????????
        FirstIsDot() ;
      else if ( IsaORiOrdOrp( sWay ))  // ???a???i???d???p    c????????????cb ??????????????????
        FirstIsaOriOrdOrp();
      else if ( sWay == 'c' )  // ????????????c???cb
        ChangeLineOrBuffer();
      else if ( sWay == '%' ) 
        FirstIsPercent();
      else if ( sWay == 'l' ) 
        List() ;
      else if ( sWay == 'b' )    // b ??? b name  **????????????error???command
        CurrentBuffer();
      else if ( sWay == 'n' )  // nb ??? nb name ??? error
        ProduceNewBuffer();
      else
        System.out.println( " Unprocessable command! Please try again." );
      
      System.out.print("> ") ;
      // i = 0 ;
      sWay = (char) System.in.read() ; // sWay = G.sIn.ReadChar();
      if ( IsWhiteSpace( sWay ) ) 
        SkipAllWhiteSpace();   // ????????????sWay[i]??????????????????white space ???
    } // while
    //G.CYPrint("Thahks for using CYICE Line Editor !"  ) ; 
    System.out.println("Thahks for using CYICE Line Editor !");
  }  // main()
} // LineEditor()
