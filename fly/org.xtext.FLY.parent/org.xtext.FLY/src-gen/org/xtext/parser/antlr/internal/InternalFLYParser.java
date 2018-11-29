package org.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.services.FLYGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalFLYParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_FLOAT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'atomic'", "'sort'", "'asc'", "'desc'", "'on'", "'='", "'+='", "'println'", "'if'", "'('", "')'", "'else'", "'for'", "'in'", "'while'", "'{'", "'}'", "'var'", "'dat'", "'random'", "'env'", "'bin'", "'opt'", "'channel'", "'['", "','", "']'", "':'", "'.'", "'Math'", "'return'", "'func'", "'!'", "'?'", "'async'", "'fly'", "'then'", "'thenall'", "'or'", "'and'", "'=='", "'!='", "'>='", "'<='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'as'", "'parse'", "'String'", "'Integer'", "'Date'", "'Dat'", "'Object'", "'Double'", "'++'", "'--'", "'time'", "'false'", "'true'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=7;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalFLYParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFLYParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFLYParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFLY.g"; }



     	private FLYGrammarAccess grammarAccess;

        public InternalFLYParser(TokenStream input, FLYGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Fly";
       	}

       	@Override
       	protected FLYGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleFly"
    // InternalFLY.g:64:1: entryRuleFly returns [EObject current=null] : iv_ruleFly= ruleFly EOF ;
    public final EObject entryRuleFly() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFly = null;


        try {
            // InternalFLY.g:64:44: (iv_ruleFly= ruleFly EOF )
            // InternalFLY.g:65:2: iv_ruleFly= ruleFly EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFly=ruleFly();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFly; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFly"


    // $ANTLR start "ruleFly"
    // InternalFLY.g:71:1: ruleFly returns [EObject current=null] : ( (lv_elements_0_0= ruleExpression ) )* ;
    public final EObject ruleFly() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:77:2: ( ( (lv_elements_0_0= ruleExpression ) )* )
            // InternalFLY.g:78:2: ( (lv_elements_0_0= ruleExpression ) )*
            {
            // InternalFLY.g:78:2: ( (lv_elements_0_0= ruleExpression ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=12 && LA1_0<=13)||(LA1_0>=19 && LA1_0<=20)||LA1_0==24||(LA1_0>=26 && LA1_0<=27)||(LA1_0>=29 && LA1_0<=35)||(LA1_0>=42 && LA1_0<=43)||(LA1_0>=46 && LA1_0<=47)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFLY.g:79:3: (lv_elements_0_0= ruleExpression )
            	    {
            	    // InternalFLY.g:79:3: (lv_elements_0_0= ruleExpression )
            	    // InternalFLY.g:80:4: lv_elements_0_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getFlyAccess().getElementsExpressionParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getFlyRule());
            	      				}
            	      				add(
            	      					current,
            	      					"elements",
            	      					lv_elements_0_0,
            	      					"org.xtext.FLY.Expression");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFly"


    // $ANTLR start "entryRuleExpression"
    // InternalFLY.g:100:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalFLY.g:100:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalFLY.g:101:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalFLY.g:107:1: ruleExpression returns [EObject current=null] : (this_Assignment_0= ruleAssignment | this_BlockExpression_1= ruleBlockExpression | this_IfExpression_2= ruleIfExpression | this_ForExpression_3= ruleForExpression | this_WhileExpression_4= ruleWhileExpression | this_PrintExpression_5= rulePrintExpression | this_FunctionDefinition_6= ruleFunctionDefinition | this_FunctionReturn_7= ruleFunctionReturn | this_FlyFunctionCall_8= ruleFlyFunctionCall | this_VariableDeclaration_9= ruleVariableDeclaration | this_ChannelSend_10= ruleChannelSend | this_ChannelReceive_11= ruleChannelReceive | this_LocalFunctionCall_12= ruleLocalFunctionCall | this_SortExpression_13= ruleSortExpression | this_AtomicExpression_14= ruleAtomicExpression | this_VariableFunction_15= ruleVariableFunction ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Assignment_0 = null;

        EObject this_BlockExpression_1 = null;

        EObject this_IfExpression_2 = null;

        EObject this_ForExpression_3 = null;

        EObject this_WhileExpression_4 = null;

        EObject this_PrintExpression_5 = null;

        EObject this_FunctionDefinition_6 = null;

        EObject this_FunctionReturn_7 = null;

        EObject this_FlyFunctionCall_8 = null;

        EObject this_VariableDeclaration_9 = null;

        EObject this_ChannelSend_10 = null;

        EObject this_ChannelReceive_11 = null;

        EObject this_LocalFunctionCall_12 = null;

        EObject this_SortExpression_13 = null;

        EObject this_AtomicExpression_14 = null;

        EObject this_VariableFunction_15 = null;



        	enterRule();

        try {
            // InternalFLY.g:113:2: ( (this_Assignment_0= ruleAssignment | this_BlockExpression_1= ruleBlockExpression | this_IfExpression_2= ruleIfExpression | this_ForExpression_3= ruleForExpression | this_WhileExpression_4= ruleWhileExpression | this_PrintExpression_5= rulePrintExpression | this_FunctionDefinition_6= ruleFunctionDefinition | this_FunctionReturn_7= ruleFunctionReturn | this_FlyFunctionCall_8= ruleFlyFunctionCall | this_VariableDeclaration_9= ruleVariableDeclaration | this_ChannelSend_10= ruleChannelSend | this_ChannelReceive_11= ruleChannelReceive | this_LocalFunctionCall_12= ruleLocalFunctionCall | this_SortExpression_13= ruleSortExpression | this_AtomicExpression_14= ruleAtomicExpression | this_VariableFunction_15= ruleVariableFunction ) )
            // InternalFLY.g:114:2: (this_Assignment_0= ruleAssignment | this_BlockExpression_1= ruleBlockExpression | this_IfExpression_2= ruleIfExpression | this_ForExpression_3= ruleForExpression | this_WhileExpression_4= ruleWhileExpression | this_PrintExpression_5= rulePrintExpression | this_FunctionDefinition_6= ruleFunctionDefinition | this_FunctionReturn_7= ruleFunctionReturn | this_FlyFunctionCall_8= ruleFlyFunctionCall | this_VariableDeclaration_9= ruleVariableDeclaration | this_ChannelSend_10= ruleChannelSend | this_ChannelReceive_11= ruleChannelReceive | this_LocalFunctionCall_12= ruleLocalFunctionCall | this_SortExpression_13= ruleSortExpression | this_AtomicExpression_14= ruleAtomicExpression | this_VariableFunction_15= ruleVariableFunction )
            {
            // InternalFLY.g:114:2: (this_Assignment_0= ruleAssignment | this_BlockExpression_1= ruleBlockExpression | this_IfExpression_2= ruleIfExpression | this_ForExpression_3= ruleForExpression | this_WhileExpression_4= ruleWhileExpression | this_PrintExpression_5= rulePrintExpression | this_FunctionDefinition_6= ruleFunctionDefinition | this_FunctionReturn_7= ruleFunctionReturn | this_FlyFunctionCall_8= ruleFlyFunctionCall | this_VariableDeclaration_9= ruleVariableDeclaration | this_ChannelSend_10= ruleChannelSend | this_ChannelReceive_11= ruleChannelReceive | this_LocalFunctionCall_12= ruleLocalFunctionCall | this_SortExpression_13= ruleSortExpression | this_AtomicExpression_14= ruleAtomicExpression | this_VariableFunction_15= ruleVariableFunction )
            int alt2=16;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalFLY.g:115:3: this_Assignment_0= ruleAssignment
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Assignment_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:124:3: this_BlockExpression_1= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getBlockExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BlockExpression_1=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalFLY.g:133:3: this_IfExpression_2= ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getIfExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfExpression_2=ruleIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalFLY.g:142:3: this_ForExpression_3= ruleForExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getForExpressionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ForExpression_3=ruleForExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ForExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalFLY.g:151:3: this_WhileExpression_4= ruleWhileExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getWhileExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_WhileExpression_4=ruleWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_WhileExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalFLY.g:160:3: this_PrintExpression_5= rulePrintExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getPrintExpressionParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PrintExpression_5=rulePrintExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PrintExpression_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalFLY.g:169:3: this_FunctionDefinition_6= ruleFunctionDefinition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getFunctionDefinitionParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionDefinition_6=ruleFunctionDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionDefinition_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalFLY.g:178:3: this_FunctionReturn_7= ruleFunctionReturn
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getFunctionReturnParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionReturn_7=ruleFunctionReturn();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionReturn_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalFLY.g:187:3: this_FlyFunctionCall_8= ruleFlyFunctionCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getFlyFunctionCallParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FlyFunctionCall_8=ruleFlyFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FlyFunctionCall_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalFLY.g:196:3: this_VariableDeclaration_9= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getVariableDeclarationParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableDeclaration_9=ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableDeclaration_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalFLY.g:205:3: this_ChannelSend_10= ruleChannelSend
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getChannelSendParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ChannelSend_10=ruleChannelSend();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ChannelSend_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalFLY.g:214:3: this_ChannelReceive_11= ruleChannelReceive
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getChannelReceiveParserRuleCall_11());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ChannelReceive_11=ruleChannelReceive();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ChannelReceive_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalFLY.g:223:3: this_LocalFunctionCall_12= ruleLocalFunctionCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getLocalFunctionCallParserRuleCall_12());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LocalFunctionCall_12=ruleLocalFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LocalFunctionCall_12;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalFLY.g:232:3: this_SortExpression_13= ruleSortExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getSortExpressionParserRuleCall_13());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SortExpression_13=ruleSortExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SortExpression_13;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalFLY.g:241:3: this_AtomicExpression_14= ruleAtomicExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getAtomicExpressionParserRuleCall_14());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AtomicExpression_14=ruleAtomicExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AtomicExpression_14;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalFLY.g:250:3: this_VariableFunction_15= ruleVariableFunction
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getVariableFunctionParserRuleCall_15());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableFunction_15=ruleVariableFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableFunction_15;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAtomicExpression"
    // InternalFLY.g:262:1: entryRuleAtomicExpression returns [EObject current=null] : iv_ruleAtomicExpression= ruleAtomicExpression EOF ;
    public final EObject entryRuleAtomicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpression = null;


        try {
            // InternalFLY.g:262:57: (iv_ruleAtomicExpression= ruleAtomicExpression EOF )
            // InternalFLY.g:263:2: iv_ruleAtomicExpression= ruleAtomicExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtomicExpression=ruleAtomicExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicExpression"


    // $ANTLR start "ruleAtomicExpression"
    // InternalFLY.g:269:1: ruleAtomicExpression returns [EObject current=null] : (otherlv_0= 'atomic' ( (lv_expressions_1_0= ruleBlockExpression ) ) ) ;
    public final EObject ruleAtomicExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expressions_1_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:275:2: ( (otherlv_0= 'atomic' ( (lv_expressions_1_0= ruleBlockExpression ) ) ) )
            // InternalFLY.g:276:2: (otherlv_0= 'atomic' ( (lv_expressions_1_0= ruleBlockExpression ) ) )
            {
            // InternalFLY.g:276:2: (otherlv_0= 'atomic' ( (lv_expressions_1_0= ruleBlockExpression ) ) )
            // InternalFLY.g:277:3: otherlv_0= 'atomic' ( (lv_expressions_1_0= ruleBlockExpression ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAtomicExpressionAccess().getAtomicKeyword_0());
              		
            }
            // InternalFLY.g:281:3: ( (lv_expressions_1_0= ruleBlockExpression ) )
            // InternalFLY.g:282:4: (lv_expressions_1_0= ruleBlockExpression )
            {
            // InternalFLY.g:282:4: (lv_expressions_1_0= ruleBlockExpression )
            // InternalFLY.g:283:5: lv_expressions_1_0= ruleBlockExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAtomicExpressionAccess().getExpressionsBlockExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expressions_1_0=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
              					}
              					set(
              						current,
              						"expressions",
              						lv_expressions_1_0,
              						"org.xtext.FLY.BlockExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicExpression"


    // $ANTLR start "entryRuleSortExpression"
    // InternalFLY.g:304:1: entryRuleSortExpression returns [EObject current=null] : iv_ruleSortExpression= ruleSortExpression EOF ;
    public final EObject entryRuleSortExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSortExpression = null;


        try {
            // InternalFLY.g:304:55: (iv_ruleSortExpression= ruleSortExpression EOF )
            // InternalFLY.g:305:2: iv_ruleSortExpression= ruleSortExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSortExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSortExpression=ruleSortExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSortExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSortExpression"


    // $ANTLR start "ruleSortExpression"
    // InternalFLY.g:311:1: ruleSortExpression returns [EObject current=null] : (otherlv_0= 'sort' ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= 'on' ( (lv_taget_4_0= RULE_ID ) ) ) ;
    public final EObject ruleSortExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_type_1_1=null;
        Token lv_type_1_2=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_taget_4_0=null;


        	enterRule();

        try {
            // InternalFLY.g:317:2: ( (otherlv_0= 'sort' ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= 'on' ( (lv_taget_4_0= RULE_ID ) ) ) )
            // InternalFLY.g:318:2: (otherlv_0= 'sort' ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= 'on' ( (lv_taget_4_0= RULE_ID ) ) )
            {
            // InternalFLY.g:318:2: (otherlv_0= 'sort' ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= 'on' ( (lv_taget_4_0= RULE_ID ) ) )
            // InternalFLY.g:319:3: otherlv_0= 'sort' ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= 'on' ( (lv_taget_4_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSortExpressionAccess().getSortKeyword_0());
              		
            }
            // InternalFLY.g:323:3: ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) )
            // InternalFLY.g:324:4: ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) )
            {
            // InternalFLY.g:324:4: ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) )
            // InternalFLY.g:325:5: (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' )
            {
            // InternalFLY.g:325:5: (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalFLY.g:326:6: lv_type_1_1= 'asc'
                    {
                    lv_type_1_1=(Token)match(input,14,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_1_1, grammarAccess.getSortExpressionAccess().getTypeAscKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSortExpressionRule());
                      						}
                      						setWithLastConsumed(current, "type", lv_type_1_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:337:6: lv_type_1_2= 'desc'
                    {
                    lv_type_1_2=(Token)match(input,15,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_1_2, grammarAccess.getSortExpressionAccess().getTypeDescKeyword_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSortExpressionRule());
                      						}
                      						setWithLastConsumed(current, "type", lv_type_1_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalFLY.g:350:3: ( (otherlv_2= RULE_ID ) )
            // InternalFLY.g:351:4: (otherlv_2= RULE_ID )
            {
            // InternalFLY.g:351:4: (otherlv_2= RULE_ID )
            // InternalFLY.g:352:5: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSortExpressionRule());
              					}
              				
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getSortExpressionAccess().getTargetVariableDeclarationCrossReference_2_0());
              				
            }

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSortExpressionAccess().getOnKeyword_3());
              		
            }
            // InternalFLY.g:367:3: ( (lv_taget_4_0= RULE_ID ) )
            // InternalFLY.g:368:4: (lv_taget_4_0= RULE_ID )
            {
            // InternalFLY.g:368:4: (lv_taget_4_0= RULE_ID )
            // InternalFLY.g:369:5: lv_taget_4_0= RULE_ID
            {
            lv_taget_4_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_taget_4_0, grammarAccess.getSortExpressionAccess().getTagetIDTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSortExpressionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"taget",
              						lv_taget_4_0,
              						"org.xtext.FLY.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSortExpression"


    // $ANTLR start "entryRuleAssignment"
    // InternalFLY.g:389:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalFLY.g:389:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalFLY.g:390:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalFLY.g:396:1: ruleAssignment returns [EObject current=null] : ( ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) ) | ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_feature_1_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_value_3_0 = null;

        EObject lv_feature_obj_5_0 = null;

        AntlrDatatypeRuleToken lv_op_6_0 = null;

        EObject lv_value_7_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:402:2: ( ( ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) ) | ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) ) ) )
            // InternalFLY.g:403:2: ( ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) ) | ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) ) )
            {
            // InternalFLY.g:403:2: ( ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) ) | ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==36||LA4_1==40) ) {
                    alt4=2;
                }
                else if ( ((LA4_1>=17 && LA4_1<=18)) ) {
                    alt4=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalFLY.g:404:3: ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) )
                    {
                    // InternalFLY.g:404:3: ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) )
                    // InternalFLY.g:405:4: () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) )
                    {
                    // InternalFLY.g:405:4: ()
                    // InternalFLY.g:406:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAssignmentAccess().getAssignmentAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:412:4: ( (lv_feature_1_0= ruleVariableLiteral ) )
                    // InternalFLY.g:413:5: (lv_feature_1_0= ruleVariableLiteral )
                    {
                    // InternalFLY.g:413:5: (lv_feature_1_0= ruleVariableLiteral )
                    // InternalFLY.g:414:6: lv_feature_1_0= ruleVariableLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getFeatureVariableLiteralParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
                    lv_feature_1_0=ruleVariableLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"feature",
                      							lv_feature_1_0,
                      							"org.xtext.FLY.VariableLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalFLY.g:431:4: ( (lv_op_2_0= ruleOpAs ) )
                    // InternalFLY.g:432:5: (lv_op_2_0= ruleOpAs )
                    {
                    // InternalFLY.g:432:5: (lv_op_2_0= ruleOpAs )
                    // InternalFLY.g:433:6: lv_op_2_0= ruleOpAs
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getOpOpAsParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_9);
                    lv_op_2_0=ruleOpAs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"op",
                      							lv_op_2_0,
                      							"org.xtext.FLY.OpAs");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalFLY.g:450:4: ( (lv_value_3_0= ruleArithmeticExpression ) )
                    // InternalFLY.g:451:5: (lv_value_3_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:451:5: (lv_value_3_0= ruleArithmeticExpression )
                    // InternalFLY.g:452:6: lv_value_3_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getValueArithmeticExpressionParserRuleCall_0_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleArithmeticExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"org.xtext.FLY.ArithmeticExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:471:3: ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) )
                    {
                    // InternalFLY.g:471:3: ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) )
                    // InternalFLY.g:472:4: () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) )
                    {
                    // InternalFLY.g:472:4: ()
                    // InternalFLY.g:473:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAssignmentAccess().getAssignmentAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:479:4: ( (lv_feature_obj_5_0= ruleObjectLiteral ) )
                    // InternalFLY.g:480:5: (lv_feature_obj_5_0= ruleObjectLiteral )
                    {
                    // InternalFLY.g:480:5: (lv_feature_obj_5_0= ruleObjectLiteral )
                    // InternalFLY.g:481:6: lv_feature_obj_5_0= ruleObjectLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getFeature_objObjectLiteralParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
                    lv_feature_obj_5_0=ruleObjectLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"feature_obj",
                      							lv_feature_obj_5_0,
                      							"org.xtext.FLY.ObjectLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalFLY.g:498:4: ( (lv_op_6_0= ruleOpAs ) )
                    // InternalFLY.g:499:5: (lv_op_6_0= ruleOpAs )
                    {
                    // InternalFLY.g:499:5: (lv_op_6_0= ruleOpAs )
                    // InternalFLY.g:500:6: lv_op_6_0= ruleOpAs
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getOpOpAsParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_9);
                    lv_op_6_0=ruleOpAs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"op",
                      							lv_op_6_0,
                      							"org.xtext.FLY.OpAs");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalFLY.g:517:4: ( (lv_value_7_0= ruleArithmeticExpression ) )
                    // InternalFLY.g:518:5: (lv_value_7_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:518:5: (lv_value_7_0= ruleArithmeticExpression )
                    // InternalFLY.g:519:6: lv_value_7_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getValueArithmeticExpressionParserRuleCall_1_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_7_0=ruleArithmeticExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_7_0,
                      							"org.xtext.FLY.ArithmeticExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleOpAs"
    // InternalFLY.g:541:1: entryRuleOpAs returns [String current=null] : iv_ruleOpAs= ruleOpAs EOF ;
    public final String entryRuleOpAs() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAs = null;


        try {
            // InternalFLY.g:541:44: (iv_ruleOpAs= ruleOpAs EOF )
            // InternalFLY.g:542:2: iv_ruleOpAs= ruleOpAs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAs=ruleOpAs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAs.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAs"


    // $ANTLR start "ruleOpAs"
    // InternalFLY.g:548:1: ruleOpAs returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' ) ;
    public final AntlrDatatypeRuleToken ruleOpAs() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:554:2: ( (kw= '=' | kw= '+=' ) )
            // InternalFLY.g:555:2: (kw= '=' | kw= '+=' )
            {
            // InternalFLY.g:555:2: (kw= '=' | kw= '+=' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            else if ( (LA5_0==18) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalFLY.g:556:3: kw= '='
                    {
                    kw=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAsAccess().getEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:562:3: kw= '+='
                    {
                    kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAsAccess().getPlusSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAs"


    // $ANTLR start "entryRulePrintExpression"
    // InternalFLY.g:571:1: entryRulePrintExpression returns [EObject current=null] : iv_rulePrintExpression= rulePrintExpression EOF ;
    public final EObject entryRulePrintExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrintExpression = null;


        try {
            // InternalFLY.g:571:56: (iv_rulePrintExpression= rulePrintExpression EOF )
            // InternalFLY.g:572:2: iv_rulePrintExpression= rulePrintExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrintExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrintExpression=rulePrintExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrintExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrintExpression"


    // $ANTLR start "rulePrintExpression"
    // InternalFLY.g:578:1: rulePrintExpression returns [EObject current=null] : ( () otherlv_1= 'println' ( (lv_print_2_0= ruleArithmeticExpression ) ) ) ;
    public final EObject rulePrintExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_print_2_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:584:2: ( ( () otherlv_1= 'println' ( (lv_print_2_0= ruleArithmeticExpression ) ) ) )
            // InternalFLY.g:585:2: ( () otherlv_1= 'println' ( (lv_print_2_0= ruleArithmeticExpression ) ) )
            {
            // InternalFLY.g:585:2: ( () otherlv_1= 'println' ( (lv_print_2_0= ruleArithmeticExpression ) ) )
            // InternalFLY.g:586:3: () otherlv_1= 'println' ( (lv_print_2_0= ruleArithmeticExpression ) )
            {
            // InternalFLY.g:586:3: ()
            // InternalFLY.g:587:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPrintExpressionAccess().getPrintExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,19,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPrintExpressionAccess().getPrintlnKeyword_1());
              		
            }
            // InternalFLY.g:597:3: ( (lv_print_2_0= ruleArithmeticExpression ) )
            // InternalFLY.g:598:4: (lv_print_2_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:598:4: (lv_print_2_0= ruleArithmeticExpression )
            // InternalFLY.g:599:5: lv_print_2_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPrintExpressionAccess().getPrintArithmeticExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_print_2_0=ruleArithmeticExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPrintExpressionRule());
              					}
              					set(
              						current,
              						"print",
              						lv_print_2_0,
              						"org.xtext.FLY.ArithmeticExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrintExpression"


    // $ANTLR start "entryRuleIfExpression"
    // InternalFLY.g:620:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalFLY.g:620:53: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalFLY.g:621:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // InternalFLY.g:627:1: ruleIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )? ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_cond_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:633:2: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )? ) )
            // InternalFLY.g:634:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )? )
            {
            // InternalFLY.g:634:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )? )
            // InternalFLY.g:635:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )?
            {
            // InternalFLY.g:635:3: ()
            // InternalFLY.g:636:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIfExpressionAccess().getIfExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfExpressionAccess().getIfKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,21,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalFLY.g:650:3: ( (lv_cond_3_0= ruleArithmeticExpression ) )
            // InternalFLY.g:651:4: (lv_cond_3_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:651:4: (lv_cond_3_0= ruleArithmeticExpression )
            // InternalFLY.g:652:5: lv_cond_3_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfExpressionAccess().getCondArithmeticExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_cond_3_0=ruleArithmeticExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              					}
              					set(
              						current,
              						"cond",
              						lv_cond_3_0,
              						"org.xtext.FLY.ArithmeticExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalFLY.g:673:3: ( (lv_then_5_0= ruleExpression ) )
            // InternalFLY.g:674:4: (lv_then_5_0= ruleExpression )
            {
            // InternalFLY.g:674:4: (lv_then_5_0= ruleExpression )
            // InternalFLY.g:675:5: lv_then_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_then_5_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_5_0,
              						"org.xtext.FLY.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalFLY.g:692:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                int LA6_1 = input.LA(2);

                if ( (synpred1_InternalFLY()) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // InternalFLY.g:693:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) )
                    {
                    // InternalFLY.g:693:4: ( ( 'else' )=>otherlv_6= 'else' )
                    // InternalFLY.g:694:5: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,23,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getIfExpressionAccess().getElseKeyword_6_0());
                      				
                    }

                    }

                    // InternalFLY.g:700:4: ( (lv_else_7_0= ruleExpression ) )
                    // InternalFLY.g:701:5: (lv_else_7_0= ruleExpression )
                    {
                    // InternalFLY.g:701:5: (lv_else_7_0= ruleExpression )
                    // InternalFLY.g:702:6: lv_else_7_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_7_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfExpressionRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_7_0,
                      							"org.xtext.FLY.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleForExpression"
    // InternalFLY.g:724:1: entryRuleForExpression returns [EObject current=null] : iv_ruleForExpression= ruleForExpression EOF ;
    public final EObject entryRuleForExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForExpression = null;


        try {
            // InternalFLY.g:724:54: (iv_ruleForExpression= ruleForExpression EOF )
            // InternalFLY.g:725:2: iv_ruleForExpression= ruleForExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleForExpression=ruleForExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForExpression"


    // $ANTLR start "ruleForExpression"
    // InternalFLY.g:731:1: ruleForExpression returns [EObject current=null] : ( () otherlv_1= 'for' ( (lv_index_2_0= ruleVariableFor ) ) otherlv_3= 'in' ( (lv_object_4_0= ruleArithmeticExpression ) ) ( (lv_body_5_0= ruleExpression ) ) ) ;
    public final EObject ruleForExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_index_2_0 = null;

        EObject lv_object_4_0 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:737:2: ( ( () otherlv_1= 'for' ( (lv_index_2_0= ruleVariableFor ) ) otherlv_3= 'in' ( (lv_object_4_0= ruleArithmeticExpression ) ) ( (lv_body_5_0= ruleExpression ) ) ) )
            // InternalFLY.g:738:2: ( () otherlv_1= 'for' ( (lv_index_2_0= ruleVariableFor ) ) otherlv_3= 'in' ( (lv_object_4_0= ruleArithmeticExpression ) ) ( (lv_body_5_0= ruleExpression ) ) )
            {
            // InternalFLY.g:738:2: ( () otherlv_1= 'for' ( (lv_index_2_0= ruleVariableFor ) ) otherlv_3= 'in' ( (lv_object_4_0= ruleArithmeticExpression ) ) ( (lv_body_5_0= ruleExpression ) ) )
            // InternalFLY.g:739:3: () otherlv_1= 'for' ( (lv_index_2_0= ruleVariableFor ) ) otherlv_3= 'in' ( (lv_object_4_0= ruleArithmeticExpression ) ) ( (lv_body_5_0= ruleExpression ) )
            {
            // InternalFLY.g:739:3: ()
            // InternalFLY.g:740:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getForExpressionAccess().getForExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,24,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getForExpressionAccess().getForKeyword_1());
              		
            }
            // InternalFLY.g:750:3: ( (lv_index_2_0= ruleVariableFor ) )
            // InternalFLY.g:751:4: (lv_index_2_0= ruleVariableFor )
            {
            // InternalFLY.g:751:4: (lv_index_2_0= ruleVariableFor )
            // InternalFLY.g:752:5: lv_index_2_0= ruleVariableFor
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForExpressionAccess().getIndexVariableForParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_index_2_0=ruleVariableFor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForExpressionRule());
              					}
              					set(
              						current,
              						"index",
              						lv_index_2_0,
              						"org.xtext.FLY.VariableFor");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getForExpressionAccess().getInKeyword_3());
              		
            }
            // InternalFLY.g:773:3: ( (lv_object_4_0= ruleArithmeticExpression ) )
            // InternalFLY.g:774:4: (lv_object_4_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:774:4: (lv_object_4_0= ruleArithmeticExpression )
            // InternalFLY.g:775:5: lv_object_4_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForExpressionAccess().getObjectArithmeticExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_object_4_0=ruleArithmeticExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForExpressionRule());
              					}
              					set(
              						current,
              						"object",
              						lv_object_4_0,
              						"org.xtext.FLY.ArithmeticExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalFLY.g:792:3: ( (lv_body_5_0= ruleExpression ) )
            // InternalFLY.g:793:4: (lv_body_5_0= ruleExpression )
            {
            // InternalFLY.g:793:4: (lv_body_5_0= ruleExpression )
            // InternalFLY.g:794:5: lv_body_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForExpressionAccess().getBodyExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_5_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForExpressionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_5_0,
              						"org.xtext.FLY.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForExpression"


    // $ANTLR start "entryRuleVariableFor"
    // InternalFLY.g:815:1: entryRuleVariableFor returns [EObject current=null] : iv_ruleVariableFor= ruleVariableFor EOF ;
    public final EObject entryRuleVariableFor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableFor = null;


        try {
            // InternalFLY.g:815:52: (iv_ruleVariableFor= ruleVariableFor EOF )
            // InternalFLY.g:816:2: iv_ruleVariableFor= ruleVariableFor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableForRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableFor=ruleVariableFor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableFor; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableFor"


    // $ANTLR start "ruleVariableFor"
    // InternalFLY.g:822:1: ruleVariableFor returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariableFor() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFLY.g:828:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFLY.g:829:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFLY.g:829:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFLY.g:830:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalFLY.g:830:3: ()
            // InternalFLY.g:831:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableForAccess().getVariableDeclarationAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:837:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFLY.g:838:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFLY.g:838:4: (lv_name_1_0= RULE_ID )
            // InternalFLY.g:839:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getVariableForAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableForRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.xtext.FLY.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableFor"


    // $ANTLR start "entryRuleWhileExpression"
    // InternalFLY.g:859:1: entryRuleWhileExpression returns [EObject current=null] : iv_ruleWhileExpression= ruleWhileExpression EOF ;
    public final EObject entryRuleWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileExpression = null;


        try {
            // InternalFLY.g:859:56: (iv_ruleWhileExpression= ruleWhileExpression EOF )
            // InternalFLY.g:860:2: iv_ruleWhileExpression= ruleWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWhileExpression=ruleWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhileExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhileExpression"


    // $ANTLR start "ruleWhileExpression"
    // InternalFLY.g:866:1: ruleWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleExpression ) ) ) ;
    public final EObject ruleWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_cond_3_0 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:872:2: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleExpression ) ) ) )
            // InternalFLY.g:873:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleExpression ) ) )
            {
            // InternalFLY.g:873:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleExpression ) ) )
            // InternalFLY.g:874:3: () otherlv_1= 'while' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleExpression ) )
            {
            // InternalFLY.g:874:3: ()
            // InternalFLY.g:875:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getWhileExpressionAccess().getWhileExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,26,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getWhileExpressionAccess().getWhileKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,21,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getWhileExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalFLY.g:889:3: ( (lv_cond_3_0= ruleArithmeticExpression ) )
            // InternalFLY.g:890:4: (lv_cond_3_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:890:4: (lv_cond_3_0= ruleArithmeticExpression )
            // InternalFLY.g:891:5: lv_cond_3_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWhileExpressionAccess().getCondArithmeticExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_cond_3_0=ruleArithmeticExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWhileExpressionRule());
              					}
              					set(
              						current,
              						"cond",
              						lv_cond_3_0,
              						"org.xtext.FLY.ArithmeticExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getWhileExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalFLY.g:912:3: ( (lv_body_5_0= ruleExpression ) )
            // InternalFLY.g:913:4: (lv_body_5_0= ruleExpression )
            {
            // InternalFLY.g:913:4: (lv_body_5_0= ruleExpression )
            // InternalFLY.g:914:5: lv_body_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWhileExpressionAccess().getBodyExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_5_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWhileExpressionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_5_0,
              						"org.xtext.FLY.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhileExpression"


    // $ANTLR start "entryRuleBlockExpression"
    // InternalFLY.g:935:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockExpression = null;


        try {
            // InternalFLY.g:935:56: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // InternalFLY.g:936:2: iv_ruleBlockExpression= ruleBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlockExpression=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockExpression"


    // $ANTLR start "ruleBlockExpression"
    // InternalFLY.g:942:1: ruleBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:948:2: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )* otherlv_3= '}' ) )
            // InternalFLY.g:949:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )* otherlv_3= '}' )
            {
            // InternalFLY.g:949:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )* otherlv_3= '}' )
            // InternalFLY.g:950:3: () otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )* otherlv_3= '}'
            {
            // InternalFLY.g:950:3: ()
            // InternalFLY.g:951:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockExpressionAccess().getBlockExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,27,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalFLY.g:961:3: ( (lv_expressions_2_0= ruleExpression ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||(LA7_0>=12 && LA7_0<=13)||(LA7_0>=19 && LA7_0<=20)||LA7_0==24||(LA7_0>=26 && LA7_0<=27)||(LA7_0>=29 && LA7_0<=35)||(LA7_0>=42 && LA7_0<=43)||(LA7_0>=46 && LA7_0<=47)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalFLY.g:962:4: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalFLY.g:962:4: (lv_expressions_2_0= ruleExpression )
            	    // InternalFLY.g:963:5: lv_expressions_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBlockExpressionAccess().getExpressionsExpressionParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_expressions_2_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBlockExpressionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"expressions",
            	      						lv_expressions_2_0,
            	      						"org.xtext.FLY.Expression");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBlockExpressionAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlockExpression"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalFLY.g:988:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalFLY.g:988:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalFLY.g:989:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalFLY.g:995:1: ruleVariableDeclaration returns [EObject current=null] : ( ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) ) | ( () ( (lv_typeobject_8_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) ) ) ) ) | ( () ( (lv_typeobject_14_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_15_0= RULE_ID ) ) ) ) | ( () ( (lv_typeobject_17_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_18_0= RULE_ID ) ) otherlv_19= '=' ( (lv_right_20_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_22_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '=' ( (lv_right_25_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_27_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_28_0= RULE_ID ) ) otherlv_29= '=' ( (lv_right_30_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_32_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_33_0= RULE_ID ) ) otherlv_34= 'on' ( (otherlv_35= RULE_ID ) ) ) ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_typeobject_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_typeobject_8_0=null;
        Token lv_name_9_0=null;
        Token otherlv_10=null;
        Token lv_typeobject_14_0=null;
        Token lv_name_15_0=null;
        Token lv_typeobject_17_0=null;
        Token lv_name_18_0=null;
        Token otherlv_19=null;
        Token lv_typeobject_22_0=null;
        Token lv_name_23_0=null;
        Token otherlv_24=null;
        Token lv_typeobject_27_0=null;
        Token lv_name_28_0=null;
        Token otherlv_29=null;
        Token lv_typeobject_32_0=null;
        Token lv_name_33_0=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        EObject lv_right_4_0 = null;

        EObject lv_right_5_0 = null;

        EObject lv_right_6_0 = null;

        EObject lv_right_11_0 = null;

        EObject lv_right_12_0 = null;

        EObject lv_right_20_0 = null;

        EObject lv_right_25_0 = null;

        EObject lv_right_30_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:1001:2: ( ( ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) ) | ( () ( (lv_typeobject_8_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) ) ) ) ) | ( () ( (lv_typeobject_14_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_15_0= RULE_ID ) ) ) ) | ( () ( (lv_typeobject_17_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_18_0= RULE_ID ) ) otherlv_19= '=' ( (lv_right_20_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_22_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '=' ( (lv_right_25_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_27_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_28_0= RULE_ID ) ) otherlv_29= '=' ( (lv_right_30_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_32_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_33_0= RULE_ID ) ) otherlv_34= 'on' ( (otherlv_35= RULE_ID ) ) ) ) ) ) )
            // InternalFLY.g:1002:2: ( ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) ) | ( () ( (lv_typeobject_8_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) ) ) ) ) | ( () ( (lv_typeobject_14_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_15_0= RULE_ID ) ) ) ) | ( () ( (lv_typeobject_17_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_18_0= RULE_ID ) ) otherlv_19= '=' ( (lv_right_20_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_22_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '=' ( (lv_right_25_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_27_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_28_0= RULE_ID ) ) otherlv_29= '=' ( (lv_right_30_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_32_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_33_0= RULE_ID ) ) otherlv_34= 'on' ( (otherlv_35= RULE_ID ) ) ) ) ) )
            {
            // InternalFLY.g:1002:2: ( ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) ) | ( () ( (lv_typeobject_8_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) ) ) ) ) | ( () ( (lv_typeobject_14_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_15_0= RULE_ID ) ) ) ) | ( () ( (lv_typeobject_17_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_18_0= RULE_ID ) ) otherlv_19= '=' ( (lv_right_20_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_22_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '=' ( (lv_right_25_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_27_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_28_0= RULE_ID ) ) otherlv_29= '=' ( (lv_right_30_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_32_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_33_0= RULE_ID ) ) otherlv_34= 'on' ( (otherlv_35= RULE_ID ) ) ) ) ) )
            int alt10=7;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt10=1;
                }
                break;
            case 30:
                {
                alt10=2;
                }
                break;
            case 31:
                {
                alt10=3;
                }
                break;
            case 32:
                {
                alt10=4;
                }
                break;
            case 33:
                {
                alt10=5;
                }
                break;
            case 34:
                {
                alt10=6;
                }
                break;
            case 35:
                {
                alt10=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalFLY.g:1003:3: ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) )
                    {
                    // InternalFLY.g:1003:3: ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) )
                    // InternalFLY.g:1004:4: () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) )
                    {
                    // InternalFLY.g:1004:4: ()
                    // InternalFLY.g:1005:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1011:4: ( (lv_typeobject_1_0= 'var' ) )
                    // InternalFLY.g:1012:5: (lv_typeobject_1_0= 'var' )
                    {
                    // InternalFLY.g:1012:5: (lv_typeobject_1_0= 'var' )
                    // InternalFLY.g:1013:6: lv_typeobject_1_0= 'var'
                    {
                    lv_typeobject_1_0=(Token)match(input,29,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_1_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectVarKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_1_0, "var");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1025:4: ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) )
                    // InternalFLY.g:1026:5: ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) )
                    {
                    // InternalFLY.g:1054:5: ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) )
                    // InternalFLY.g:1055:6: ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) )
                    {
                    // InternalFLY.g:1055:6: ( (lv_name_2_0= RULE_ID ) )
                    // InternalFLY.g:1056:7: (lv_name_2_0= RULE_ID )
                    {
                    // InternalFLY.g:1056:7: (lv_name_2_0= RULE_ID )
                    // InternalFLY.g:1057:8: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_2_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_0_2_0_0_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_2_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_0_2_0_1());
                      					
                    }
                    // InternalFLY.g:1077:6: ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) )
                    int alt8=3;
                    switch ( input.LA(1) ) {
                    case RULE_ID:
                    case RULE_STRING:
                    case RULE_INT:
                    case RULE_FLOAT:
                    case 21:
                    case 41:
                    case 58:
                    case 59:
                    case 62:
                    case 73:
                    case 74:
                    case 75:
                        {
                        alt8=1;
                        }
                        break;
                    case 36:
                        {
                        int LA8_2 = input.LA(2);

                        if ( (LA8_2==RULE_INT) ) {
                            int LA8_4 = input.LA(3);

                            if ( ((LA8_4>=37 && LA8_4<=38)||(LA8_4>=50 && LA8_4<=61)||(LA8_4>=63 && LA8_4<=64)||(LA8_4>=71 && LA8_4<=72)) ) {
                                alt8=2;
                            }
                            else if ( (LA8_4==39) ) {
                                alt8=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 4, input);

                                throw nvae;
                            }
                        }
                        else if ( ((LA8_2>=RULE_ID && LA8_2<=RULE_STRING)||LA8_2==RULE_FLOAT||LA8_2==21||(LA8_2>=36 && LA8_2<=38)||LA8_2==41||(LA8_2>=58 && LA8_2<=59)||LA8_2==62||(LA8_2>=73 && LA8_2<=75)) ) {
                            alt8=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 46:
                    case 47:
                        {
                        alt8=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }

                    switch (alt8) {
                        case 1 :
                            // InternalFLY.g:1078:7: ( (lv_right_4_0= ruleArithmeticExpression ) )
                            {
                            // InternalFLY.g:1078:7: ( (lv_right_4_0= ruleArithmeticExpression ) )
                            // InternalFLY.g:1079:8: (lv_right_4_0= ruleArithmeticExpression )
                            {
                            // InternalFLY.g:1079:8: (lv_right_4_0= ruleArithmeticExpression )
                            // InternalFLY.g:1080:9: lv_right_4_0= ruleArithmeticExpression
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightArithmeticExpressionParserRuleCall_0_2_0_2_0_0());
                              								
                            }
                            pushFollow(FOLLOW_2);
                            lv_right_4_0=ruleArithmeticExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                              									}
                              									set(
                              										current,
                              										"right",
                              										lv_right_4_0,
                              										"org.xtext.FLY.ArithmeticExpression");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalFLY.g:1098:7: ( (lv_right_5_0= ruleObject ) )
                            {
                            // InternalFLY.g:1098:7: ( (lv_right_5_0= ruleObject ) )
                            // InternalFLY.g:1099:8: (lv_right_5_0= ruleObject )
                            {
                            // InternalFLY.g:1099:8: (lv_right_5_0= ruleObject )
                            // InternalFLY.g:1100:9: lv_right_5_0= ruleObject
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightObjectParserRuleCall_0_2_0_2_1_0());
                              								
                            }
                            pushFollow(FOLLOW_2);
                            lv_right_5_0=ruleObject();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                              									}
                              									set(
                              										current,
                              										"right",
                              										lv_right_5_0,
                              										"org.xtext.FLY.Object");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalFLY.g:1118:7: ( (lv_right_6_0= ruleFlyFunctionCall ) )
                            {
                            // InternalFLY.g:1118:7: ( (lv_right_6_0= ruleFlyFunctionCall ) )
                            // InternalFLY.g:1119:8: (lv_right_6_0= ruleFlyFunctionCall )
                            {
                            // InternalFLY.g:1119:8: (lv_right_6_0= ruleFlyFunctionCall )
                            // InternalFLY.g:1120:9: lv_right_6_0= ruleFlyFunctionCall
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightFlyFunctionCallParserRuleCall_0_2_0_2_2_0());
                              								
                            }
                            pushFollow(FOLLOW_2);
                            lv_right_6_0=ruleFlyFunctionCall();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                              									}
                              									set(
                              										current,
                              										"right",
                              										lv_right_6_0,
                              										"org.xtext.FLY.FlyFunctionCall");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:1142:3: ( () ( (lv_typeobject_8_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) ) ) ) )
                    {
                    // InternalFLY.g:1142:3: ( () ( (lv_typeobject_8_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) ) ) ) )
                    // InternalFLY.g:1143:4: () ( (lv_typeobject_8_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) ) ) )
                    {
                    // InternalFLY.g:1143:4: ()
                    // InternalFLY.g:1144:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getDatDeclarationAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1150:4: ( (lv_typeobject_8_0= 'dat' ) )
                    // InternalFLY.g:1151:5: (lv_typeobject_8_0= 'dat' )
                    {
                    // InternalFLY.g:1151:5: (lv_typeobject_8_0= 'dat' )
                    // InternalFLY.g:1152:6: lv_typeobject_8_0= 'dat'
                    {
                    lv_typeobject_8_0=(Token)match(input,30,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_8_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectDatKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_8_0, "dat");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1164:4: ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) ) ) )
                    // InternalFLY.g:1165:5: ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) ) )
                    {
                    // InternalFLY.g:1187:5: ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) ) )
                    // InternalFLY.g:1188:6: ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) )
                    {
                    // InternalFLY.g:1188:6: ( (lv_name_9_0= RULE_ID ) )
                    // InternalFLY.g:1189:7: (lv_name_9_0= RULE_ID )
                    {
                    // InternalFLY.g:1189:7: (lv_name_9_0= RULE_ID )
                    // InternalFLY.g:1190:8: lv_name_9_0= RULE_ID
                    {
                    lv_name_9_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_9_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_2_0_0_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_9_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_10, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_1_2_0_1());
                      					
                    }
                    // InternalFLY.g:1210:6: ( ( (lv_right_11_0= ruleArithmeticExpression ) ) | ( (lv_right_12_0= ruleObject ) ) )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_FLOAT)||LA9_0==21||LA9_0==41||(LA9_0>=58 && LA9_0<=59)||LA9_0==62||(LA9_0>=73 && LA9_0<=75)) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==36) ) {
                        int LA9_2 = input.LA(2);

                        if ( (LA9_2==RULE_INT) ) {
                            int LA9_3 = input.LA(3);

                            if ( ((LA9_3>=37 && LA9_3<=38)||(LA9_3>=50 && LA9_3<=61)||(LA9_3>=63 && LA9_3<=64)||(LA9_3>=71 && LA9_3<=72)) ) {
                                alt9=2;
                            }
                            else if ( (LA9_3==39) ) {
                                alt9=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( ((LA9_2>=RULE_ID && LA9_2<=RULE_STRING)||LA9_2==RULE_FLOAT||LA9_2==21||(LA9_2>=36 && LA9_2<=38)||LA9_2==41||(LA9_2>=58 && LA9_2<=59)||LA9_2==62||(LA9_2>=73 && LA9_2<=75)) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalFLY.g:1211:7: ( (lv_right_11_0= ruleArithmeticExpression ) )
                            {
                            // InternalFLY.g:1211:7: ( (lv_right_11_0= ruleArithmeticExpression ) )
                            // InternalFLY.g:1212:8: (lv_right_11_0= ruleArithmeticExpression )
                            {
                            // InternalFLY.g:1212:8: (lv_right_11_0= ruleArithmeticExpression )
                            // InternalFLY.g:1213:9: lv_right_11_0= ruleArithmeticExpression
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightArithmeticExpressionParserRuleCall_1_2_0_2_0_0());
                              								
                            }
                            pushFollow(FOLLOW_2);
                            lv_right_11_0=ruleArithmeticExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                              									}
                              									set(
                              										current,
                              										"right",
                              										lv_right_11_0,
                              										"org.xtext.FLY.ArithmeticExpression");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalFLY.g:1231:7: ( (lv_right_12_0= ruleObject ) )
                            {
                            // InternalFLY.g:1231:7: ( (lv_right_12_0= ruleObject ) )
                            // InternalFLY.g:1232:8: (lv_right_12_0= ruleObject )
                            {
                            // InternalFLY.g:1232:8: (lv_right_12_0= ruleObject )
                            // InternalFLY.g:1233:9: lv_right_12_0= ruleObject
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightObjectParserRuleCall_1_2_0_2_1_0());
                              								
                            }
                            pushFollow(FOLLOW_2);
                            lv_right_12_0=ruleObject();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                              									}
                              									set(
                              										current,
                              										"right",
                              										lv_right_12_0,
                              										"org.xtext.FLY.Object");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFLY.g:1255:3: ( () ( (lv_typeobject_14_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_15_0= RULE_ID ) ) ) )
                    {
                    // InternalFLY.g:1255:3: ( () ( (lv_typeobject_14_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_15_0= RULE_ID ) ) ) )
                    // InternalFLY.g:1256:4: () ( (lv_typeobject_14_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_15_0= RULE_ID ) ) )
                    {
                    // InternalFLY.g:1256:4: ()
                    // InternalFLY.g:1257:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getRandomDeclarationAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1263:4: ( (lv_typeobject_14_0= 'random' ) )
                    // InternalFLY.g:1264:5: (lv_typeobject_14_0= 'random' )
                    {
                    // InternalFLY.g:1264:5: (lv_typeobject_14_0= 'random' )
                    // InternalFLY.g:1265:6: lv_typeobject_14_0= 'random'
                    {
                    lv_typeobject_14_0=(Token)match(input,31,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_14_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectRandomKeyword_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_14_0, "random");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1277:4: ( ( ( ( RULE_ID ) ) )=> ( (lv_name_15_0= RULE_ID ) ) )
                    // InternalFLY.g:1278:5: ( ( ( RULE_ID ) ) )=> ( (lv_name_15_0= RULE_ID ) )
                    {
                    // InternalFLY.g:1284:5: ( (lv_name_15_0= RULE_ID ) )
                    // InternalFLY.g:1285:6: (lv_name_15_0= RULE_ID )
                    {
                    // InternalFLY.g:1285:6: (lv_name_15_0= RULE_ID )
                    // InternalFLY.g:1286:7: lv_name_15_0= RULE_ID
                    {
                    lv_name_15_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_name_15_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_2_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"name",
                      								lv_name_15_0,
                      								"org.xtext.FLY.ID");
                      						
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalFLY.g:1305:3: ( () ( (lv_typeobject_17_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_18_0= RULE_ID ) ) otherlv_19= '=' ( (lv_right_20_0= ruleDeclarationObject ) ) ) ) )
                    {
                    // InternalFLY.g:1305:3: ( () ( (lv_typeobject_17_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_18_0= RULE_ID ) ) otherlv_19= '=' ( (lv_right_20_0= ruleDeclarationObject ) ) ) ) )
                    // InternalFLY.g:1306:4: () ( (lv_typeobject_17_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_18_0= RULE_ID ) ) otherlv_19= '=' ( (lv_right_20_0= ruleDeclarationObject ) ) ) )
                    {
                    // InternalFLY.g:1306:4: ()
                    // InternalFLY.g:1307:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getEnvironmentDeclarationAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1313:4: ( (lv_typeobject_17_0= 'env' ) )
                    // InternalFLY.g:1314:5: (lv_typeobject_17_0= 'env' )
                    {
                    // InternalFLY.g:1314:5: (lv_typeobject_17_0= 'env' )
                    // InternalFLY.g:1315:6: lv_typeobject_17_0= 'env'
                    {
                    lv_typeobject_17_0=(Token)match(input,32,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_17_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectEnvKeyword_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_17_0, "env");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1327:4: ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_18_0= RULE_ID ) ) otherlv_19= '=' ( (lv_right_20_0= ruleDeclarationObject ) ) ) )
                    // InternalFLY.g:1328:5: ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_18_0= RULE_ID ) ) otherlv_19= '=' ( (lv_right_20_0= ruleDeclarationObject ) ) )
                    {
                    // InternalFLY.g:1342:5: ( ( (lv_name_18_0= RULE_ID ) ) otherlv_19= '=' ( (lv_right_20_0= ruleDeclarationObject ) ) )
                    // InternalFLY.g:1343:6: ( (lv_name_18_0= RULE_ID ) ) otherlv_19= '=' ( (lv_right_20_0= ruleDeclarationObject ) )
                    {
                    // InternalFLY.g:1343:6: ( (lv_name_18_0= RULE_ID ) )
                    // InternalFLY.g:1344:7: (lv_name_18_0= RULE_ID )
                    {
                    // InternalFLY.g:1344:7: (lv_name_18_0= RULE_ID )
                    // InternalFLY.g:1345:8: lv_name_18_0= RULE_ID
                    {
                    lv_name_18_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_18_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_3_2_0_0_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_18_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }

                    otherlv_19=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_19, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_2_0_1());
                      					
                    }
                    // InternalFLY.g:1365:6: ( (lv_right_20_0= ruleDeclarationObject ) )
                    // InternalFLY.g:1366:7: (lv_right_20_0= ruleDeclarationObject )
                    {
                    // InternalFLY.g:1366:7: (lv_right_20_0= ruleDeclarationObject )
                    // InternalFLY.g:1367:8: lv_right_20_0= ruleDeclarationObject
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightDeclarationObjectParserRuleCall_3_2_0_2_0());
                      							
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_20_0=ruleDeclarationObject();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      								}
                      								set(
                      									current,
                      									"right",
                      									lv_right_20_0,
                      									"org.xtext.FLY.DeclarationObject");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }


                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalFLY.g:1388:3: ( () ( (lv_typeobject_22_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '=' ( (lv_right_25_0= ruleDeclarationObject ) ) ) ) )
                    {
                    // InternalFLY.g:1388:3: ( () ( (lv_typeobject_22_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '=' ( (lv_right_25_0= ruleDeclarationObject ) ) ) ) )
                    // InternalFLY.g:1389:4: () ( (lv_typeobject_22_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '=' ( (lv_right_25_0= ruleDeclarationObject ) ) ) )
                    {
                    // InternalFLY.g:1389:4: ()
                    // InternalFLY.g:1390:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getBinDeclarationAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1396:4: ( (lv_typeobject_22_0= 'bin' ) )
                    // InternalFLY.g:1397:5: (lv_typeobject_22_0= 'bin' )
                    {
                    // InternalFLY.g:1397:5: (lv_typeobject_22_0= 'bin' )
                    // InternalFLY.g:1398:6: lv_typeobject_22_0= 'bin'
                    {
                    lv_typeobject_22_0=(Token)match(input,33,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_22_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectBinKeyword_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_22_0, "bin");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1410:4: ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '=' ( (lv_right_25_0= ruleDeclarationObject ) ) ) )
                    // InternalFLY.g:1411:5: ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '=' ( (lv_right_25_0= ruleDeclarationObject ) ) )
                    {
                    // InternalFLY.g:1425:5: ( ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '=' ( (lv_right_25_0= ruleDeclarationObject ) ) )
                    // InternalFLY.g:1426:6: ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '=' ( (lv_right_25_0= ruleDeclarationObject ) )
                    {
                    // InternalFLY.g:1426:6: ( (lv_name_23_0= RULE_ID ) )
                    // InternalFLY.g:1427:7: (lv_name_23_0= RULE_ID )
                    {
                    // InternalFLY.g:1427:7: (lv_name_23_0= RULE_ID )
                    // InternalFLY.g:1428:8: lv_name_23_0= RULE_ID
                    {
                    lv_name_23_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_23_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_4_2_0_0_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_23_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }

                    otherlv_24=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_24, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_4_2_0_1());
                      					
                    }
                    // InternalFLY.g:1448:6: ( (lv_right_25_0= ruleDeclarationObject ) )
                    // InternalFLY.g:1449:7: (lv_right_25_0= ruleDeclarationObject )
                    {
                    // InternalFLY.g:1449:7: (lv_right_25_0= ruleDeclarationObject )
                    // InternalFLY.g:1450:8: lv_right_25_0= ruleDeclarationObject
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightDeclarationObjectParserRuleCall_4_2_0_2_0());
                      							
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_25_0=ruleDeclarationObject();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      								}
                      								set(
                      									current,
                      									"right",
                      									lv_right_25_0,
                      									"org.xtext.FLY.DeclarationObject");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalFLY.g:1471:3: ( () ( (lv_typeobject_27_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_28_0= RULE_ID ) ) otherlv_29= '=' ( (lv_right_30_0= ruleDeclarationObject ) ) ) ) )
                    {
                    // InternalFLY.g:1471:3: ( () ( (lv_typeobject_27_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_28_0= RULE_ID ) ) otherlv_29= '=' ( (lv_right_30_0= ruleDeclarationObject ) ) ) ) )
                    // InternalFLY.g:1472:4: () ( (lv_typeobject_27_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_28_0= RULE_ID ) ) otherlv_29= '=' ( (lv_right_30_0= ruleDeclarationObject ) ) ) )
                    {
                    // InternalFLY.g:1472:4: ()
                    // InternalFLY.g:1473:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getOptimizerDeclarationAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1479:4: ( (lv_typeobject_27_0= 'opt' ) )
                    // InternalFLY.g:1480:5: (lv_typeobject_27_0= 'opt' )
                    {
                    // InternalFLY.g:1480:5: (lv_typeobject_27_0= 'opt' )
                    // InternalFLY.g:1481:6: lv_typeobject_27_0= 'opt'
                    {
                    lv_typeobject_27_0=(Token)match(input,34,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_27_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectOptKeyword_5_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_27_0, "opt");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1493:4: ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_28_0= RULE_ID ) ) otherlv_29= '=' ( (lv_right_30_0= ruleDeclarationObject ) ) ) )
                    // InternalFLY.g:1494:5: ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_28_0= RULE_ID ) ) otherlv_29= '=' ( (lv_right_30_0= ruleDeclarationObject ) ) )
                    {
                    // InternalFLY.g:1508:5: ( ( (lv_name_28_0= RULE_ID ) ) otherlv_29= '=' ( (lv_right_30_0= ruleDeclarationObject ) ) )
                    // InternalFLY.g:1509:6: ( (lv_name_28_0= RULE_ID ) ) otherlv_29= '=' ( (lv_right_30_0= ruleDeclarationObject ) )
                    {
                    // InternalFLY.g:1509:6: ( (lv_name_28_0= RULE_ID ) )
                    // InternalFLY.g:1510:7: (lv_name_28_0= RULE_ID )
                    {
                    // InternalFLY.g:1510:7: (lv_name_28_0= RULE_ID )
                    // InternalFLY.g:1511:8: lv_name_28_0= RULE_ID
                    {
                    lv_name_28_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_28_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_5_2_0_0_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_28_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }

                    otherlv_29=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_29, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_5_2_0_1());
                      					
                    }
                    // InternalFLY.g:1531:6: ( (lv_right_30_0= ruleDeclarationObject ) )
                    // InternalFLY.g:1532:7: (lv_right_30_0= ruleDeclarationObject )
                    {
                    // InternalFLY.g:1532:7: (lv_right_30_0= ruleDeclarationObject )
                    // InternalFLY.g:1533:8: lv_right_30_0= ruleDeclarationObject
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightDeclarationObjectParserRuleCall_5_2_0_2_0());
                      							
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_30_0=ruleDeclarationObject();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      								}
                      								set(
                      									current,
                      									"right",
                      									lv_right_30_0,
                      									"org.xtext.FLY.DeclarationObject");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalFLY.g:1554:3: ( () ( (lv_typeobject_32_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_33_0= RULE_ID ) ) otherlv_34= 'on' ( (otherlv_35= RULE_ID ) ) ) ) )
                    {
                    // InternalFLY.g:1554:3: ( () ( (lv_typeobject_32_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_33_0= RULE_ID ) ) otherlv_34= 'on' ( (otherlv_35= RULE_ID ) ) ) ) )
                    // InternalFLY.g:1555:4: () ( (lv_typeobject_32_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_33_0= RULE_ID ) ) otherlv_34= 'on' ( (otherlv_35= RULE_ID ) ) ) )
                    {
                    // InternalFLY.g:1555:4: ()
                    // InternalFLY.g:1556:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getChannelDeclarationAction_6_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1562:4: ( (lv_typeobject_32_0= 'channel' ) )
                    // InternalFLY.g:1563:5: (lv_typeobject_32_0= 'channel' )
                    {
                    // InternalFLY.g:1563:5: (lv_typeobject_32_0= 'channel' )
                    // InternalFLY.g:1564:6: lv_typeobject_32_0= 'channel'
                    {
                    lv_typeobject_32_0=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_32_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectChannelKeyword_6_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_32_0, "channel");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1576:4: ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_33_0= RULE_ID ) ) otherlv_34= 'on' ( (otherlv_35= RULE_ID ) ) ) )
                    // InternalFLY.g:1577:5: ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_33_0= RULE_ID ) ) otherlv_34= 'on' ( (otherlv_35= RULE_ID ) ) )
                    {
                    // InternalFLY.g:1591:5: ( ( (lv_name_33_0= RULE_ID ) ) otherlv_34= 'on' ( (otherlv_35= RULE_ID ) ) )
                    // InternalFLY.g:1592:6: ( (lv_name_33_0= RULE_ID ) ) otherlv_34= 'on' ( (otherlv_35= RULE_ID ) )
                    {
                    // InternalFLY.g:1592:6: ( (lv_name_33_0= RULE_ID ) )
                    // InternalFLY.g:1593:7: (lv_name_33_0= RULE_ID )
                    {
                    // InternalFLY.g:1593:7: (lv_name_33_0= RULE_ID )
                    // InternalFLY.g:1594:8: lv_name_33_0= RULE_ID
                    {
                    lv_name_33_0=(Token)match(input,RULE_ID,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_33_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_6_2_0_0_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_33_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }

                    otherlv_34=(Token)match(input,16,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_34, grammarAccess.getVariableDeclarationAccess().getOnKeyword_6_2_0_1());
                      					
                    }
                    // InternalFLY.g:1614:6: ( (otherlv_35= RULE_ID ) )
                    // InternalFLY.g:1615:7: (otherlv_35= RULE_ID )
                    {
                    // InternalFLY.g:1615:7: (otherlv_35= RULE_ID )
                    // InternalFLY.g:1616:8: otherlv_35= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      							
                    }
                    otherlv_35=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(otherlv_35, grammarAccess.getVariableDeclarationAccess().getEnvironmentEnvironmentDeclarationCrossReference_6_2_0_2_0());
                      							
                    }

                    }


                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleObject"
    // InternalFLY.g:1634:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // InternalFLY.g:1634:47: (iv_ruleObject= ruleObject EOF )
            // InternalFLY.g:1635:2: iv_ruleObject= ruleObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleObject=ruleObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObject; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // InternalFLY.g:1641:1: ruleObject returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_features_2_0 = null;

        EObject lv_features_4_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:1647:2: ( ( () otherlv_1= '[' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= ']' ) )
            // InternalFLY.g:1648:2: ( () otherlv_1= '[' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= ']' )
            {
            // InternalFLY.g:1648:2: ( () otherlv_1= '[' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= ']' )
            // InternalFLY.g:1649:3: () otherlv_1= '[' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= ']'
            {
            // InternalFLY.g:1649:3: ()
            // InternalFLY.g:1650:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getObjectAccess().getNameObjectDefAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getObjectAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalFLY.g:1660:3: ( (lv_features_2_0= ruleFeautureName ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=RULE_ID && LA11_0<=RULE_FLOAT)||LA11_0==21||LA11_0==36||LA11_0==41||(LA11_0>=58 && LA11_0<=59)||LA11_0==62||(LA11_0>=73 && LA11_0<=75)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalFLY.g:1661:4: (lv_features_2_0= ruleFeautureName )
                    {
                    // InternalFLY.g:1661:4: (lv_features_2_0= ruleFeautureName )
                    // InternalFLY.g:1662:5: lv_features_2_0= ruleFeautureName
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeautureNameParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
                    lv_features_2_0=ruleFeautureName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getObjectRule());
                      					}
                      					add(
                      						current,
                      						"features",
                      						lv_features_2_0,
                      						"org.xtext.FLY.FeautureName");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalFLY.g:1679:3: (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==37) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFLY.g:1680:4: otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) )
            	    {
            	    otherlv_3=(Token)match(input,37,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getObjectAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalFLY.g:1684:4: ( (lv_features_4_0= ruleFeautureName ) )
            	    // InternalFLY.g:1685:5: (lv_features_4_0= ruleFeautureName )
            	    {
            	    // InternalFLY.g:1685:5: (lv_features_4_0= ruleFeautureName )
            	    // InternalFLY.g:1686:6: lv_features_4_0= ruleFeautureName
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeautureNameParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_features_4_0=ruleFeautureName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getObjectRule());
            	      						}
            	      						add(
            	      							current,
            	      							"features",
            	      							lv_features_4_0,
            	      							"org.xtext.FLY.FeautureName");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_5=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getObjectAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleDeclarationObject"
    // InternalFLY.g:1712:1: entryRuleDeclarationObject returns [EObject current=null] : iv_ruleDeclarationObject= ruleDeclarationObject EOF ;
    public final EObject entryRuleDeclarationObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationObject = null;


        try {
            // InternalFLY.g:1712:58: (iv_ruleDeclarationObject= ruleDeclarationObject EOF )
            // InternalFLY.g:1713:2: iv_ruleDeclarationObject= ruleDeclarationObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationObjectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclarationObject=ruleDeclarationObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarationObject; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclarationObject"


    // $ANTLR start "ruleDeclarationObject"
    // InternalFLY.g:1719:1: ruleDeclarationObject returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_features_2_0= ruleDeclarationFeature ) ) (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleDeclarationObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_features_2_0 = null;

        EObject lv_features_4_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:1725:2: ( ( () otherlv_1= '[' ( (lv_features_2_0= ruleDeclarationFeature ) ) (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )* otherlv_5= ']' ) )
            // InternalFLY.g:1726:2: ( () otherlv_1= '[' ( (lv_features_2_0= ruleDeclarationFeature ) ) (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )* otherlv_5= ']' )
            {
            // InternalFLY.g:1726:2: ( () otherlv_1= '[' ( (lv_features_2_0= ruleDeclarationFeature ) ) (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )* otherlv_5= ']' )
            // InternalFLY.g:1727:3: () otherlv_1= '[' ( (lv_features_2_0= ruleDeclarationFeature ) ) (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )* otherlv_5= ']'
            {
            // InternalFLY.g:1727:3: ()
            // InternalFLY.g:1728:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDeclarationObjectAccess().getDeclarationObjectAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDeclarationObjectAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalFLY.g:1738:3: ( (lv_features_2_0= ruleDeclarationFeature ) )
            // InternalFLY.g:1739:4: (lv_features_2_0= ruleDeclarationFeature )
            {
            // InternalFLY.g:1739:4: (lv_features_2_0= ruleDeclarationFeature )
            // InternalFLY.g:1740:5: lv_features_2_0= ruleDeclarationFeature
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclarationObjectAccess().getFeaturesDeclarationFeatureParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_20);
            lv_features_2_0=ruleDeclarationFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeclarationObjectRule());
              					}
              					add(
              						current,
              						"features",
              						lv_features_2_0,
              						"org.xtext.FLY.DeclarationFeature");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalFLY.g:1757:3: (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==37) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalFLY.g:1758:4: otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) )
            	    {
            	    otherlv_3=(Token)match(input,37,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getDeclarationObjectAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalFLY.g:1762:4: ( (lv_features_4_0= ruleDeclarationFeature ) )
            	    // InternalFLY.g:1763:5: (lv_features_4_0= ruleDeclarationFeature )
            	    {
            	    // InternalFLY.g:1763:5: (lv_features_4_0= ruleDeclarationFeature )
            	    // InternalFLY.g:1764:6: lv_features_4_0= ruleDeclarationFeature
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDeclarationObjectAccess().getFeaturesDeclarationFeatureParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_features_4_0=ruleDeclarationFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getDeclarationObjectRule());
            	      						}
            	      						add(
            	      							current,
            	      							"features",
            	      							lv_features_4_0,
            	      							"org.xtext.FLY.DeclarationFeature");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_5=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getDeclarationObjectAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclarationObject"


    // $ANTLR start "entryRuleDeclarationFeature"
    // InternalFLY.g:1790:1: entryRuleDeclarationFeature returns [EObject current=null] : iv_ruleDeclarationFeature= ruleDeclarationFeature EOF ;
    public final EObject entryRuleDeclarationFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationFeature = null;


        try {
            // InternalFLY.g:1790:59: (iv_ruleDeclarationFeature= ruleDeclarationFeature EOF )
            // InternalFLY.g:1791:2: iv_ruleDeclarationFeature= ruleDeclarationFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclarationFeature=ruleDeclarationFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarationFeature; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclarationFeature"


    // $ANTLR start "ruleDeclarationFeature"
    // InternalFLY.g:1797:1: ruleDeclarationFeature returns [EObject current=null] : ( () ( (lv_feature_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) ) ) ;
    public final EObject ruleDeclarationFeature() throws RecognitionException {
        EObject current = null;

        Token lv_feature_1_0=null;
        Token otherlv_2=null;
        Token lv_value_f_3_0=null;
        Token lv_value_s_4_0=null;
        Token lv_value_t_5_0=null;
        EObject lv_value_b_6_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:1803:2: ( ( () ( (lv_feature_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) ) ) )
            // InternalFLY.g:1804:2: ( () ( (lv_feature_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) ) )
            {
            // InternalFLY.g:1804:2: ( () ( (lv_feature_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) ) )
            // InternalFLY.g:1805:3: () ( (lv_feature_1_0= RULE_ID ) ) otherlv_2= ':' ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) )
            {
            // InternalFLY.g:1805:3: ()
            // InternalFLY.g:1806:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDeclarationFeatureAccess().getDeclarationFeatureAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:1812:3: ( (lv_feature_1_0= RULE_ID ) )
            // InternalFLY.g:1813:4: (lv_feature_1_0= RULE_ID )
            {
            // InternalFLY.g:1813:4: (lv_feature_1_0= RULE_ID )
            // InternalFLY.g:1814:5: lv_feature_1_0= RULE_ID
            {
            lv_feature_1_0=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_feature_1_0, grammarAccess.getDeclarationFeatureAccess().getFeatureIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDeclarationFeatureRule());
              					}
              					setWithLastConsumed(
              						current,
              						"feature",
              						lv_feature_1_0,
              						"org.xtext.FLY.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDeclarationFeatureAccess().getColonKeyword_2());
              		
            }
            // InternalFLY.g:1834:3: ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt14=1;
                }
                break;
            case RULE_STRING:
                {
                alt14=2;
                }
                break;
            case RULE_INT:
                {
                alt14=3;
                }
                break;
            case 74:
            case 75:
                {
                alt14=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalFLY.g:1835:4: ( (lv_value_f_3_0= RULE_ID ) )
                    {
                    // InternalFLY.g:1835:4: ( (lv_value_f_3_0= RULE_ID ) )
                    // InternalFLY.g:1836:5: (lv_value_f_3_0= RULE_ID )
                    {
                    // InternalFLY.g:1836:5: (lv_value_f_3_0= RULE_ID )
                    // InternalFLY.g:1837:6: lv_value_f_3_0= RULE_ID
                    {
                    lv_value_f_3_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_f_3_0, grammarAccess.getDeclarationFeatureAccess().getValue_fIDTerminalRuleCall_3_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDeclarationFeatureRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value_f",
                      							lv_value_f_3_0,
                      							"org.xtext.FLY.ID");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:1854:4: ( (lv_value_s_4_0= RULE_STRING ) )
                    {
                    // InternalFLY.g:1854:4: ( (lv_value_s_4_0= RULE_STRING ) )
                    // InternalFLY.g:1855:5: (lv_value_s_4_0= RULE_STRING )
                    {
                    // InternalFLY.g:1855:5: (lv_value_s_4_0= RULE_STRING )
                    // InternalFLY.g:1856:6: lv_value_s_4_0= RULE_STRING
                    {
                    lv_value_s_4_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_s_4_0, grammarAccess.getDeclarationFeatureAccess().getValue_sSTRINGTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDeclarationFeatureRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value_s",
                      							lv_value_s_4_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFLY.g:1873:4: ( (lv_value_t_5_0= RULE_INT ) )
                    {
                    // InternalFLY.g:1873:4: ( (lv_value_t_5_0= RULE_INT ) )
                    // InternalFLY.g:1874:5: (lv_value_t_5_0= RULE_INT )
                    {
                    // InternalFLY.g:1874:5: (lv_value_t_5_0= RULE_INT )
                    // InternalFLY.g:1875:6: lv_value_t_5_0= RULE_INT
                    {
                    lv_value_t_5_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_t_5_0, grammarAccess.getDeclarationFeatureAccess().getValue_tINTTerminalRuleCall_3_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDeclarationFeatureRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value_t",
                      							lv_value_t_5_0,
                      							"org.eclipse.xtext.common.Terminals.INT");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalFLY.g:1892:4: ( (lv_value_b_6_0= ruleBooleanLiteral ) )
                    {
                    // InternalFLY.g:1892:4: ( (lv_value_b_6_0= ruleBooleanLiteral ) )
                    // InternalFLY.g:1893:5: (lv_value_b_6_0= ruleBooleanLiteral )
                    {
                    // InternalFLY.g:1893:5: (lv_value_b_6_0= ruleBooleanLiteral )
                    // InternalFLY.g:1894:6: lv_value_b_6_0= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDeclarationFeatureAccess().getValue_bBooleanLiteralParserRuleCall_3_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_b_6_0=ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDeclarationFeatureRule());
                      						}
                      						set(
                      							current,
                      							"value_b",
                      							lv_value_b_6_0,
                      							"org.xtext.FLY.BooleanLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclarationFeature"


    // $ANTLR start "entryRuleFeautureName"
    // InternalFLY.g:1916:1: entryRuleFeautureName returns [EObject current=null] : iv_ruleFeautureName= ruleFeautureName EOF ;
    public final EObject entryRuleFeautureName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeautureName = null;


        try {
            // InternalFLY.g:1916:53: (iv_ruleFeautureName= ruleFeautureName EOF )
            // InternalFLY.g:1917:2: iv_ruleFeautureName= ruleFeautureName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeautureNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeautureName=ruleFeautureName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeautureName; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeautureName"


    // $ANTLR start "ruleFeautureName"
    // InternalFLY.g:1923:1: ruleFeautureName returns [EObject current=null] : ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleArithmeticExpression ) ) ) | ( (lv_value_3_0= ruleArithmeticExpression ) ) ) ;
    public final EObject ruleFeautureName() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:1929:2: ( ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleArithmeticExpression ) ) ) | ( (lv_value_3_0= ruleArithmeticExpression ) ) ) )
            // InternalFLY.g:1930:2: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleArithmeticExpression ) ) ) | ( (lv_value_3_0= ruleArithmeticExpression ) ) )
            {
            // InternalFLY.g:1930:2: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleArithmeticExpression ) ) ) | ( (lv_value_3_0= ruleArithmeticExpression ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==EOF||LA15_1==21||(LA15_1>=36 && LA15_1<=38)||LA15_1==40||(LA15_1>=44 && LA15_1<=45)||(LA15_1>=50 && LA15_1<=61)||(LA15_1>=63 && LA15_1<=64)||(LA15_1>=71 && LA15_1<=72)) ) {
                    alt15=2;
                }
                else if ( (LA15_1==39) ) {
                    alt15=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_FLOAT)||LA15_0==21||LA15_0==36||LA15_0==41||(LA15_0>=58 && LA15_0<=59)||LA15_0==62||(LA15_0>=73 && LA15_0<=75)) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalFLY.g:1931:3: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleArithmeticExpression ) ) )
                    {
                    // InternalFLY.g:1931:3: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleArithmeticExpression ) ) )
                    // InternalFLY.g:1932:4: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleArithmeticExpression ) )
                    {
                    // InternalFLY.g:1932:4: ( (lv_feature_0_0= RULE_ID ) )
                    // InternalFLY.g:1933:5: (lv_feature_0_0= RULE_ID )
                    {
                    // InternalFLY.g:1933:5: (lv_feature_0_0= RULE_ID )
                    // InternalFLY.g:1934:6: lv_feature_0_0= RULE_ID
                    {
                    lv_feature_0_0=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_feature_0_0, grammarAccess.getFeautureNameAccess().getFeatureIDTerminalRuleCall_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFeautureNameRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"feature",
                      							lv_feature_0_0,
                      							"org.xtext.FLY.ID");
                      					
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,39,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getFeautureNameAccess().getColonKeyword_0_1());
                      			
                    }
                    // InternalFLY.g:1954:4: ( (lv_value_2_0= ruleArithmeticExpression ) )
                    // InternalFLY.g:1955:5: (lv_value_2_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:1955:5: (lv_value_2_0= ruleArithmeticExpression )
                    // InternalFLY.g:1956:6: lv_value_2_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFeautureNameAccess().getValueArithmeticExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_2_0=ruleArithmeticExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFeautureNameRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_2_0,
                      							"org.xtext.FLY.ArithmeticExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:1975:3: ( (lv_value_3_0= ruleArithmeticExpression ) )
                    {
                    // InternalFLY.g:1975:3: ( (lv_value_3_0= ruleArithmeticExpression ) )
                    // InternalFLY.g:1976:4: (lv_value_3_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:1976:4: (lv_value_3_0= ruleArithmeticExpression )
                    // InternalFLY.g:1977:5: lv_value_3_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFeautureNameAccess().getValueArithmeticExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleArithmeticExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFeautureNameRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_3_0,
                      						"org.xtext.FLY.ArithmeticExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeautureName"


    // $ANTLR start "entryRuleObjectLiteral"
    // InternalFLY.g:1998:1: entryRuleObjectLiteral returns [EObject current=null] : iv_ruleObjectLiteral= ruleObjectLiteral EOF ;
    public final EObject entryRuleObjectLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectLiteral = null;


        try {
            // InternalFLY.g:1998:54: (iv_ruleObjectLiteral= ruleObjectLiteral EOF )
            // InternalFLY.g:1999:2: iv_ruleObjectLiteral= ruleObjectLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleObjectLiteral=ruleObjectLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectLiteral"


    // $ANTLR start "ruleObjectLiteral"
    // InternalFLY.g:2005:1: ruleObjectLiteral returns [EObject current=null] : ( ( () ( (otherlv_1= RULE_ID ) ) ( ( ( '.' ( ( RULE_ID ) ) ) )=> (otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) ) ) | ( () ( (otherlv_5= RULE_ID ) ) ( ( ( '[' ( ( RULE_INT ) ) ']' ) )=> (otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']' ) ) ) | ( () ( (otherlv_10= RULE_ID ) ) ( ( ( '[' ( ( RULE_ID ) ) ']' ) )=> (otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']' ) ) ) | ( () ( (otherlv_15= RULE_ID ) ) ( ( ( '[' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ',' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ']' ) )=> (otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']' ) ) ) | ( () ( (otherlv_22= RULE_ID ) ) ( ( ( '[' ( ( ( ruleRangeLiteral ) ) | ( ( ruleNumberLiteral ) ) ) ',' ( ( ruleRangeLiteral ) ) ']' ) )=> (otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']' ) ) ) ) ;
    public final EObject ruleObjectLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_valuet_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        EObject lv_value1_17_1 = null;

        EObject lv_value1_17_2 = null;

        EObject lv_value2_19_1 = null;

        EObject lv_value2_19_2 = null;

        EObject lv_range1_24_0 = null;

        EObject lv_range1_t_25_0 = null;

        EObject lv_range2_27_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:2011:2: ( ( ( () ( (otherlv_1= RULE_ID ) ) ( ( ( '.' ( ( RULE_ID ) ) ) )=> (otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) ) ) | ( () ( (otherlv_5= RULE_ID ) ) ( ( ( '[' ( ( RULE_INT ) ) ']' ) )=> (otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']' ) ) ) | ( () ( (otherlv_10= RULE_ID ) ) ( ( ( '[' ( ( RULE_ID ) ) ']' ) )=> (otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']' ) ) ) | ( () ( (otherlv_15= RULE_ID ) ) ( ( ( '[' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ',' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ']' ) )=> (otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']' ) ) ) | ( () ( (otherlv_22= RULE_ID ) ) ( ( ( '[' ( ( ( ruleRangeLiteral ) ) | ( ( ruleNumberLiteral ) ) ) ',' ( ( ruleRangeLiteral ) ) ']' ) )=> (otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']' ) ) ) ) )
            // InternalFLY.g:2012:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( ( ( '.' ( ( RULE_ID ) ) ) )=> (otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) ) ) | ( () ( (otherlv_5= RULE_ID ) ) ( ( ( '[' ( ( RULE_INT ) ) ']' ) )=> (otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']' ) ) ) | ( () ( (otherlv_10= RULE_ID ) ) ( ( ( '[' ( ( RULE_ID ) ) ']' ) )=> (otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']' ) ) ) | ( () ( (otherlv_15= RULE_ID ) ) ( ( ( '[' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ',' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ']' ) )=> (otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']' ) ) ) | ( () ( (otherlv_22= RULE_ID ) ) ( ( ( '[' ( ( ( ruleRangeLiteral ) ) | ( ( ruleNumberLiteral ) ) ) ',' ( ( ruleRangeLiteral ) ) ']' ) )=> (otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']' ) ) ) )
            {
            // InternalFLY.g:2012:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( ( ( '.' ( ( RULE_ID ) ) ) )=> (otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) ) ) | ( () ( (otherlv_5= RULE_ID ) ) ( ( ( '[' ( ( RULE_INT ) ) ']' ) )=> (otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']' ) ) ) | ( () ( (otherlv_10= RULE_ID ) ) ( ( ( '[' ( ( RULE_ID ) ) ']' ) )=> (otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']' ) ) ) | ( () ( (otherlv_15= RULE_ID ) ) ( ( ( '[' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ',' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ']' ) )=> (otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']' ) ) ) | ( () ( (otherlv_22= RULE_ID ) ) ( ( ( '[' ( ( ( ruleRangeLiteral ) ) | ( ( ruleNumberLiteral ) ) ) ',' ( ( ruleRangeLiteral ) ) ']' ) )=> (otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']' ) ) ) )
            int alt19=5;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalFLY.g:2013:3: ( () ( (otherlv_1= RULE_ID ) ) ( ( ( '.' ( ( RULE_ID ) ) ) )=> (otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) ) )
                    {
                    // InternalFLY.g:2013:3: ( () ( (otherlv_1= RULE_ID ) ) ( ( ( '.' ( ( RULE_ID ) ) ) )=> (otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) ) )
                    // InternalFLY.g:2014:4: () ( (otherlv_1= RULE_ID ) ) ( ( ( '.' ( ( RULE_ID ) ) ) )=> (otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) )
                    {
                    // InternalFLY.g:2014:4: ()
                    // InternalFLY.g:2015:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectLiteralAccess().getNameObjectAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:2021:4: ( (otherlv_1= RULE_ID ) )
                    // InternalFLY.g:2022:5: (otherlv_1= RULE_ID )
                    {
                    // InternalFLY.g:2022:5: (otherlv_1= RULE_ID )
                    // InternalFLY.g:2023:6: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getObjectLiteralRule());
                      						}
                      					
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_1, grammarAccess.getObjectLiteralAccess().getNameVariableDeclarationCrossReference_0_1_0());
                      					
                    }

                    }


                    }

                    // InternalFLY.g:2034:4: ( ( ( '.' ( ( RULE_ID ) ) ) )=> (otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) )
                    // InternalFLY.g:2035:5: ( ( '.' ( ( RULE_ID ) ) ) )=> (otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) )
                    {
                    // InternalFLY.g:2044:5: (otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) )
                    // InternalFLY.g:2045:6: otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_2, grammarAccess.getObjectLiteralAccess().getFullStopKeyword_0_2_0_0());
                      					
                    }
                    // InternalFLY.g:2049:6: ( (lv_value_3_0= RULE_ID ) )
                    // InternalFLY.g:2050:7: (lv_value_3_0= RULE_ID )
                    {
                    // InternalFLY.g:2050:7: (lv_value_3_0= RULE_ID )
                    // InternalFLY.g:2051:8: lv_value_3_0= RULE_ID
                    {
                    lv_value_3_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_value_3_0, grammarAccess.getObjectLiteralAccess().getValueIDTerminalRuleCall_0_2_0_1_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getObjectLiteralRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"value",
                      									lv_value_3_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:2071:3: ( () ( (otherlv_5= RULE_ID ) ) ( ( ( '[' ( ( RULE_INT ) ) ']' ) )=> (otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']' ) ) )
                    {
                    // InternalFLY.g:2071:3: ( () ( (otherlv_5= RULE_ID ) ) ( ( ( '[' ( ( RULE_INT ) ) ']' ) )=> (otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']' ) ) )
                    // InternalFLY.g:2072:4: () ( (otherlv_5= RULE_ID ) ) ( ( ( '[' ( ( RULE_INT ) ) ']' ) )=> (otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']' ) )
                    {
                    // InternalFLY.g:2072:4: ()
                    // InternalFLY.g:2073:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectLiteralAccess().getIndexObjectAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:2079:4: ( (otherlv_5= RULE_ID ) )
                    // InternalFLY.g:2080:5: (otherlv_5= RULE_ID )
                    {
                    // InternalFLY.g:2080:5: (otherlv_5= RULE_ID )
                    // InternalFLY.g:2081:6: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getObjectLiteralRule());
                      						}
                      					
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_5, grammarAccess.getObjectLiteralAccess().getNameVariableDeclarationCrossReference_1_1_0());
                      					
                    }

                    }


                    }

                    // InternalFLY.g:2092:4: ( ( ( '[' ( ( RULE_INT ) ) ']' ) )=> (otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']' ) )
                    // InternalFLY.g:2093:5: ( ( '[' ( ( RULE_INT ) ) ']' ) )=> (otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']' )
                    {
                    // InternalFLY.g:2103:5: (otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']' )
                    // InternalFLY.g:2104:6: otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']'
                    {
                    otherlv_6=(Token)match(input,36,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_6, grammarAccess.getObjectLiteralAccess().getLeftSquareBracketKeyword_1_2_0_0());
                      					
                    }
                    // InternalFLY.g:2108:6: ( (lv_valuet_7_0= RULE_INT ) )
                    // InternalFLY.g:2109:7: (lv_valuet_7_0= RULE_INT )
                    {
                    // InternalFLY.g:2109:7: (lv_valuet_7_0= RULE_INT )
                    // InternalFLY.g:2110:8: lv_valuet_7_0= RULE_INT
                    {
                    lv_valuet_7_0=(Token)match(input,RULE_INT,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_valuet_7_0, grammarAccess.getObjectLiteralAccess().getValuetINTTerminalRuleCall_1_2_0_1_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getObjectLiteralRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"valuet",
                      									lv_valuet_7_0,
                      									"org.eclipse.xtext.common.Terminals.INT");
                      							
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_8, grammarAccess.getObjectLiteralAccess().getRightSquareBracketKeyword_1_2_0_2());
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFLY.g:2134:3: ( () ( (otherlv_10= RULE_ID ) ) ( ( ( '[' ( ( RULE_ID ) ) ']' ) )=> (otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']' ) ) )
                    {
                    // InternalFLY.g:2134:3: ( () ( (otherlv_10= RULE_ID ) ) ( ( ( '[' ( ( RULE_ID ) ) ']' ) )=> (otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']' ) ) )
                    // InternalFLY.g:2135:4: () ( (otherlv_10= RULE_ID ) ) ( ( ( '[' ( ( RULE_ID ) ) ']' ) )=> (otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']' ) )
                    {
                    // InternalFLY.g:2135:4: ()
                    // InternalFLY.g:2136:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectLiteralAccess().getIndexObjectAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:2142:4: ( (otherlv_10= RULE_ID ) )
                    // InternalFLY.g:2143:5: (otherlv_10= RULE_ID )
                    {
                    // InternalFLY.g:2143:5: (otherlv_10= RULE_ID )
                    // InternalFLY.g:2144:6: otherlv_10= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getObjectLiteralRule());
                      						}
                      					
                    }
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_10, grammarAccess.getObjectLiteralAccess().getNameVariableDeclarationCrossReference_2_1_0());
                      					
                    }

                    }


                    }

                    // InternalFLY.g:2155:4: ( ( ( '[' ( ( RULE_ID ) ) ']' ) )=> (otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']' ) )
                    // InternalFLY.g:2156:5: ( ( '[' ( ( RULE_ID ) ) ']' ) )=> (otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']' )
                    {
                    // InternalFLY.g:2166:5: (otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']' )
                    // InternalFLY.g:2167:6: otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']'
                    {
                    otherlv_11=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_11, grammarAccess.getObjectLiteralAccess().getLeftSquareBracketKeyword_2_2_0_0());
                      					
                    }
                    // InternalFLY.g:2171:6: ( (otherlv_12= RULE_ID ) )
                    // InternalFLY.g:2172:7: (otherlv_12= RULE_ID )
                    {
                    // InternalFLY.g:2172:7: (otherlv_12= RULE_ID )
                    // InternalFLY.g:2173:8: otherlv_12= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getObjectLiteralRule());
                      								}
                      							
                    }
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(otherlv_12, grammarAccess.getObjectLiteralAccess().getValueVariableDeclarationCrossReference_2_2_0_1_0());
                      							
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_13, grammarAccess.getObjectLiteralAccess().getRightSquareBracketKeyword_2_2_0_2());
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalFLY.g:2192:3: ( () ( (otherlv_15= RULE_ID ) ) ( ( ( '[' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ',' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ']' ) )=> (otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']' ) ) )
                    {
                    // InternalFLY.g:2192:3: ( () ( (otherlv_15= RULE_ID ) ) ( ( ( '[' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ',' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ']' ) )=> (otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']' ) ) )
                    // InternalFLY.g:2193:4: () ( (otherlv_15= RULE_ID ) ) ( ( ( '[' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ',' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ']' ) )=> (otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']' ) )
                    {
                    // InternalFLY.g:2193:4: ()
                    // InternalFLY.g:2194:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectLiteralAccess().getDatSingleObjectAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:2200:4: ( (otherlv_15= RULE_ID ) )
                    // InternalFLY.g:2201:5: (otherlv_15= RULE_ID )
                    {
                    // InternalFLY.g:2201:5: (otherlv_15= RULE_ID )
                    // InternalFLY.g:2202:6: otherlv_15= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getObjectLiteralRule());
                      						}
                      					
                    }
                    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_15, grammarAccess.getObjectLiteralAccess().getNameVariableDeclarationCrossReference_3_1_0());
                      					
                    }

                    }


                    }

                    // InternalFLY.g:2213:4: ( ( ( '[' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ',' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ']' ) )=> (otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']' ) )
                    // InternalFLY.g:2214:5: ( ( '[' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ',' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ']' ) )=> (otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']' )
                    {
                    // InternalFLY.g:2236:5: (otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']' )
                    // InternalFLY.g:2237:6: otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']'
                    {
                    otherlv_16=(Token)match(input,36,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_16, grammarAccess.getObjectLiteralAccess().getLeftSquareBracketKeyword_3_2_0_0());
                      					
                    }
                    // InternalFLY.g:2241:6: ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) )
                    // InternalFLY.g:2242:7: ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) )
                    {
                    // InternalFLY.g:2242:7: ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) )
                    // InternalFLY.g:2243:8: (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral )
                    {
                    // InternalFLY.g:2243:8: (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_INT) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==RULE_STRING) ) {
                        alt16=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalFLY.g:2244:9: lv_value1_17_1= ruleNumberLiteral
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getObjectLiteralAccess().getValue1NumberLiteralParserRuleCall_3_2_0_1_0_0());
                              								
                            }
                            pushFollow(FOLLOW_27);
                            lv_value1_17_1=ruleNumberLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              									}
                              									set(
                              										current,
                              										"value1",
                              										lv_value1_17_1,
                              										"org.xtext.FLY.NumberLiteral");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }
                            break;
                        case 2 :
                            // InternalFLY.g:2260:9: lv_value1_17_2= ruleStringLiteral
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getObjectLiteralAccess().getValue1StringLiteralParserRuleCall_3_2_0_1_0_1());
                              								
                            }
                            pushFollow(FOLLOW_27);
                            lv_value1_17_2=ruleStringLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              									}
                              									set(
                              										current,
                              										"value1",
                              										lv_value1_17_2,
                              										"org.xtext.FLY.StringLiteral");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_18=(Token)match(input,37,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_18, grammarAccess.getObjectLiteralAccess().getCommaKeyword_3_2_0_2());
                      					
                    }
                    // InternalFLY.g:2282:6: ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) )
                    // InternalFLY.g:2283:7: ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) )
                    {
                    // InternalFLY.g:2283:7: ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) )
                    // InternalFLY.g:2284:8: (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral )
                    {
                    // InternalFLY.g:2284:8: (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_INT) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==RULE_STRING) ) {
                        alt17=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalFLY.g:2285:9: lv_value2_19_1= ruleNumberLiteral
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getObjectLiteralAccess().getValue2NumberLiteralParserRuleCall_3_2_0_3_0_0());
                              								
                            }
                            pushFollow(FOLLOW_25);
                            lv_value2_19_1=ruleNumberLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              									}
                              									set(
                              										current,
                              										"value2",
                              										lv_value2_19_1,
                              										"org.xtext.FLY.NumberLiteral");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }
                            break;
                        case 2 :
                            // InternalFLY.g:2301:9: lv_value2_19_2= ruleStringLiteral
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getObjectLiteralAccess().getValue2StringLiteralParserRuleCall_3_2_0_3_0_1());
                              								
                            }
                            pushFollow(FOLLOW_25);
                            lv_value2_19_2=ruleStringLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              									}
                              									set(
                              										current,
                              										"value2",
                              										lv_value2_19_2,
                              										"org.xtext.FLY.StringLiteral");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_20=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_20, grammarAccess.getObjectLiteralAccess().getRightSquareBracketKeyword_3_2_0_4());
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalFLY.g:2327:3: ( () ( (otherlv_22= RULE_ID ) ) ( ( ( '[' ( ( ( ruleRangeLiteral ) ) | ( ( ruleNumberLiteral ) ) ) ',' ( ( ruleRangeLiteral ) ) ']' ) )=> (otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']' ) ) )
                    {
                    // InternalFLY.g:2327:3: ( () ( (otherlv_22= RULE_ID ) ) ( ( ( '[' ( ( ( ruleRangeLiteral ) ) | ( ( ruleNumberLiteral ) ) ) ',' ( ( ruleRangeLiteral ) ) ']' ) )=> (otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']' ) ) )
                    // InternalFLY.g:2328:4: () ( (otherlv_22= RULE_ID ) ) ( ( ( '[' ( ( ( ruleRangeLiteral ) ) | ( ( ruleNumberLiteral ) ) ) ',' ( ( ruleRangeLiteral ) ) ']' ) )=> (otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']' ) )
                    {
                    // InternalFLY.g:2328:4: ()
                    // InternalFLY.g:2329:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectLiteralAccess().getDatTableObjectAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:2335:4: ( (otherlv_22= RULE_ID ) )
                    // InternalFLY.g:2336:5: (otherlv_22= RULE_ID )
                    {
                    // InternalFLY.g:2336:5: (otherlv_22= RULE_ID )
                    // InternalFLY.g:2337:6: otherlv_22= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getObjectLiteralRule());
                      						}
                      					
                    }
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_22, grammarAccess.getObjectLiteralAccess().getNameVariableDeclarationCrossReference_4_1_0());
                      					
                    }

                    }


                    }

                    // InternalFLY.g:2348:4: ( ( ( '[' ( ( ( ruleRangeLiteral ) ) | ( ( ruleNumberLiteral ) ) ) ',' ( ( ruleRangeLiteral ) ) ']' ) )=> (otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']' ) )
                    // InternalFLY.g:2349:5: ( ( '[' ( ( ( ruleRangeLiteral ) ) | ( ( ruleNumberLiteral ) ) ) ',' ( ( ruleRangeLiteral ) ) ']' ) )=> (otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']' )
                    {
                    // InternalFLY.g:2373:5: (otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']' )
                    // InternalFLY.g:2374:6: otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']'
                    {
                    otherlv_23=(Token)match(input,36,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_23, grammarAccess.getObjectLiteralAccess().getLeftSquareBracketKeyword_4_2_0_0());
                      					
                    }
                    // InternalFLY.g:2378:6: ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==36) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==RULE_INT) ) {
                        alt18=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalFLY.g:2379:7: ( (lv_range1_24_0= ruleRangeLiteral ) )
                            {
                            // InternalFLY.g:2379:7: ( (lv_range1_24_0= ruleRangeLiteral ) )
                            // InternalFLY.g:2380:8: (lv_range1_24_0= ruleRangeLiteral )
                            {
                            // InternalFLY.g:2380:8: (lv_range1_24_0= ruleRangeLiteral )
                            // InternalFLY.g:2381:9: lv_range1_24_0= ruleRangeLiteral
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getObjectLiteralAccess().getRange1RangeLiteralParserRuleCall_4_2_0_1_0_0());
                              								
                            }
                            pushFollow(FOLLOW_27);
                            lv_range1_24_0=ruleRangeLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              									}
                              									set(
                              										current,
                              										"range1",
                              										lv_range1_24_0,
                              										"org.xtext.FLY.RangeLiteral");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalFLY.g:2399:7: ( (lv_range1_t_25_0= ruleNumberLiteral ) )
                            {
                            // InternalFLY.g:2399:7: ( (lv_range1_t_25_0= ruleNumberLiteral ) )
                            // InternalFLY.g:2400:8: (lv_range1_t_25_0= ruleNumberLiteral )
                            {
                            // InternalFLY.g:2400:8: (lv_range1_t_25_0= ruleNumberLiteral )
                            // InternalFLY.g:2401:9: lv_range1_t_25_0= ruleNumberLiteral
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getObjectLiteralAccess().getRange1_tNumberLiteralParserRuleCall_4_2_0_1_1_0());
                              								
                            }
                            pushFollow(FOLLOW_27);
                            lv_range1_t_25_0=ruleNumberLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              									}
                              									set(
                              										current,
                              										"range1_t",
                              										lv_range1_t_25_0,
                              										"org.xtext.FLY.NumberLiteral");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_26=(Token)match(input,37,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_26, grammarAccess.getObjectLiteralAccess().getCommaKeyword_4_2_0_2());
                      					
                    }
                    // InternalFLY.g:2423:6: ( (lv_range2_27_0= ruleRangeLiteral ) )
                    // InternalFLY.g:2424:7: (lv_range2_27_0= ruleRangeLiteral )
                    {
                    // InternalFLY.g:2424:7: (lv_range2_27_0= ruleRangeLiteral )
                    // InternalFLY.g:2425:8: lv_range2_27_0= ruleRangeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getObjectLiteralAccess().getRange2RangeLiteralParserRuleCall_4_2_0_3_0());
                      							
                    }
                    pushFollow(FOLLOW_25);
                    lv_range2_27_0=ruleRangeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                      								}
                      								set(
                      									current,
                      									"range2",
                      									lv_range2_27_0,
                      									"org.xtext.FLY.RangeLiteral");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }

                    otherlv_28=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_28, grammarAccess.getObjectLiteralAccess().getRightSquareBracketKeyword_4_2_0_4());
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectLiteral"


    // $ANTLR start "entryRuleRangeLiteral"
    // InternalFLY.g:2453:1: entryRuleRangeLiteral returns [EObject current=null] : iv_ruleRangeLiteral= ruleRangeLiteral EOF ;
    public final EObject entryRuleRangeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeLiteral = null;


        try {
            // InternalFLY.g:2453:53: (iv_ruleRangeLiteral= ruleRangeLiteral EOF )
            // InternalFLY.g:2454:2: iv_ruleRangeLiteral= ruleRangeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRangeLiteral=ruleRangeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeLiteral"


    // $ANTLR start "ruleRangeLiteral"
    // InternalFLY.g:2460:1: ruleRangeLiteral returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_value1_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_value2_4_0= RULE_INT ) ) otherlv_5= ']' ) ;
    public final EObject ruleRangeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_value1_2_0=null;
        Token otherlv_3=null;
        Token lv_value2_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalFLY.g:2466:2: ( ( () otherlv_1= '[' ( (lv_value1_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_value2_4_0= RULE_INT ) ) otherlv_5= ']' ) )
            // InternalFLY.g:2467:2: ( () otherlv_1= '[' ( (lv_value1_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_value2_4_0= RULE_INT ) ) otherlv_5= ']' )
            {
            // InternalFLY.g:2467:2: ( () otherlv_1= '[' ( (lv_value1_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_value2_4_0= RULE_INT ) ) otherlv_5= ']' )
            // InternalFLY.g:2468:3: () otherlv_1= '[' ( (lv_value1_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_value2_4_0= RULE_INT ) ) otherlv_5= ']'
            {
            // InternalFLY.g:2468:3: ()
            // InternalFLY.g:2469:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRangeLiteralAccess().getRangeLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,36,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRangeLiteralAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalFLY.g:2479:3: ( (lv_value1_2_0= RULE_INT ) )
            // InternalFLY.g:2480:4: (lv_value1_2_0= RULE_INT )
            {
            // InternalFLY.g:2480:4: (lv_value1_2_0= RULE_INT )
            // InternalFLY.g:2481:5: lv_value1_2_0= RULE_INT
            {
            lv_value1_2_0=(Token)match(input,RULE_INT,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value1_2_0, grammarAccess.getRangeLiteralAccess().getValue1INTTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRangeLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value1",
              						lv_value1_2_0,
              						"org.eclipse.xtext.common.Terminals.INT");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,39,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRangeLiteralAccess().getColonKeyword_3());
              		
            }
            // InternalFLY.g:2501:3: ( (lv_value2_4_0= RULE_INT ) )
            // InternalFLY.g:2502:4: (lv_value2_4_0= RULE_INT )
            {
            // InternalFLY.g:2502:4: (lv_value2_4_0= RULE_INT )
            // InternalFLY.g:2503:5: lv_value2_4_0= RULE_INT
            {
            lv_value2_4_0=(Token)match(input,RULE_INT,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value2_4_0, grammarAccess.getRangeLiteralAccess().getValue2INTTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRangeLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value2",
              						lv_value2_4_0,
              						"org.eclipse.xtext.common.Terminals.INT");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRangeLiteralAccess().getRightSquareBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRangeLiteral"


    // $ANTLR start "entryRuleMathFunction"
    // InternalFLY.g:2527:1: entryRuleMathFunction returns [EObject current=null] : iv_ruleMathFunction= ruleMathFunction EOF ;
    public final EObject entryRuleMathFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathFunction = null;


        try {
            // InternalFLY.g:2527:53: (iv_ruleMathFunction= ruleMathFunction EOF )
            // InternalFLY.g:2528:2: iv_ruleMathFunction= ruleMathFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMathFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMathFunction=ruleMathFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMathFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMathFunction"


    // $ANTLR start "ruleMathFunction"
    // InternalFLY.g:2534:1: ruleMathFunction returns [EObject current=null] : ( () otherlv_1= 'Math' otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' ) ;
    public final EObject ruleMathFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_feature_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_expressions_5_0 = null;

        EObject lv_expressions_7_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:2540:2: ( ( () otherlv_1= 'Math' otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' ) )
            // InternalFLY.g:2541:2: ( () otherlv_1= 'Math' otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' )
            {
            // InternalFLY.g:2541:2: ( () otherlv_1= 'Math' otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' )
            // InternalFLY.g:2542:3: () otherlv_1= 'Math' otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')'
            {
            // InternalFLY.g:2542:3: ()
            // InternalFLY.g:2543:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMathFunctionAccess().getMathFunctionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,41,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMathFunctionAccess().getMathKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,40,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getMathFunctionAccess().getFullStopKeyword_2());
              		
            }
            // InternalFLY.g:2557:3: ( (lv_feature_3_0= RULE_ID ) )
            // InternalFLY.g:2558:4: (lv_feature_3_0= RULE_ID )
            {
            // InternalFLY.g:2558:4: (lv_feature_3_0= RULE_ID )
            // InternalFLY.g:2559:5: lv_feature_3_0= RULE_ID
            {
            lv_feature_3_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_feature_3_0, grammarAccess.getMathFunctionAccess().getFeatureIDTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getMathFunctionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"feature",
              						lv_feature_3_0,
              						"org.xtext.FLY.ID");
              				
            }

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getMathFunctionAccess().getLeftParenthesisKeyword_4());
              		
            }
            // InternalFLY.g:2579:3: ( (lv_expressions_5_0= ruleArithmeticExpression ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_FLOAT)||LA20_0==21||LA20_0==36||LA20_0==41||(LA20_0>=58 && LA20_0<=59)||LA20_0==62||(LA20_0>=73 && LA20_0<=75)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalFLY.g:2580:4: (lv_expressions_5_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:2580:4: (lv_expressions_5_0= ruleArithmeticExpression )
                    // InternalFLY.g:2581:5: lv_expressions_5_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getMathFunctionAccess().getExpressionsArithmeticExpressionParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_30);
                    lv_expressions_5_0=ruleArithmeticExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getMathFunctionRule());
                      					}
                      					add(
                      						current,
                      						"expressions",
                      						lv_expressions_5_0,
                      						"org.xtext.FLY.ArithmeticExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalFLY.g:2598:3: (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==37) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalFLY.g:2599:4: otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) )
            	    {
            	    otherlv_6=(Token)match(input,37,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getMathFunctionAccess().getCommaKeyword_6_0());
            	      			
            	    }
            	    // InternalFLY.g:2603:4: ( (lv_expressions_7_0= ruleArithmeticExpression ) )
            	    // InternalFLY.g:2604:5: (lv_expressions_7_0= ruleArithmeticExpression )
            	    {
            	    // InternalFLY.g:2604:5: (lv_expressions_7_0= ruleArithmeticExpression )
            	    // InternalFLY.g:2605:6: lv_expressions_7_0= ruleArithmeticExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMathFunctionAccess().getExpressionsArithmeticExpressionParserRuleCall_6_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_expressions_7_0=ruleArithmeticExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMathFunctionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_7_0,
            	      							"org.xtext.FLY.ArithmeticExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_8=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getMathFunctionAccess().getRightParenthesisKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMathFunction"


    // $ANTLR start "entryRuleVariableFunction"
    // InternalFLY.g:2631:1: entryRuleVariableFunction returns [EObject current=null] : iv_ruleVariableFunction= ruleVariableFunction EOF ;
    public final EObject entryRuleVariableFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableFunction = null;


        try {
            // InternalFLY.g:2631:57: (iv_ruleVariableFunction= ruleVariableFunction EOF )
            // InternalFLY.g:2632:2: iv_ruleVariableFunction= ruleVariableFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableFunction=ruleVariableFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableFunction"


    // $ANTLR start "ruleVariableFunction"
    // InternalFLY.g:2638:1: ruleVariableFunction returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' ) ;
    public final EObject ruleVariableFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_feature_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_expressions_5_0 = null;

        EObject lv_expressions_7_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:2644:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' ) )
            // InternalFLY.g:2645:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' )
            {
            // InternalFLY.g:2645:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' )
            // InternalFLY.g:2646:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')'
            {
            // InternalFLY.g:2646:3: ()
            // InternalFLY.g:2647:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableFunctionAccess().getVariableFunctionAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:2653:3: ( (otherlv_1= RULE_ID ) )
            // InternalFLY.g:2654:4: (otherlv_1= RULE_ID )
            {
            // InternalFLY.g:2654:4: (otherlv_1= RULE_ID )
            // InternalFLY.g:2655:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableFunctionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getVariableFunctionAccess().getTargetVariableDeclarationCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,40,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getVariableFunctionAccess().getFullStopKeyword_2());
              		
            }
            // InternalFLY.g:2670:3: ( (lv_feature_3_0= RULE_ID ) )
            // InternalFLY.g:2671:4: (lv_feature_3_0= RULE_ID )
            {
            // InternalFLY.g:2671:4: (lv_feature_3_0= RULE_ID )
            // InternalFLY.g:2672:5: lv_feature_3_0= RULE_ID
            {
            lv_feature_3_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_feature_3_0, grammarAccess.getVariableFunctionAccess().getFeatureIDTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableFunctionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"feature",
              						lv_feature_3_0,
              						"org.xtext.FLY.ID");
              				
            }

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getVariableFunctionAccess().getLeftParenthesisKeyword_4());
              		
            }
            // InternalFLY.g:2692:3: ( (lv_expressions_5_0= ruleArithmeticExpression ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_FLOAT)||LA22_0==21||LA22_0==36||LA22_0==41||(LA22_0>=58 && LA22_0<=59)||LA22_0==62||(LA22_0>=73 && LA22_0<=75)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalFLY.g:2693:4: (lv_expressions_5_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:2693:4: (lv_expressions_5_0= ruleArithmeticExpression )
                    // InternalFLY.g:2694:5: lv_expressions_5_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVariableFunctionAccess().getExpressionsArithmeticExpressionParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_30);
                    lv_expressions_5_0=ruleArithmeticExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getVariableFunctionRule());
                      					}
                      					add(
                      						current,
                      						"expressions",
                      						lv_expressions_5_0,
                      						"org.xtext.FLY.ArithmeticExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalFLY.g:2711:3: (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==37) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalFLY.g:2712:4: otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) )
            	    {
            	    otherlv_6=(Token)match(input,37,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getVariableFunctionAccess().getCommaKeyword_6_0());
            	      			
            	    }
            	    // InternalFLY.g:2716:4: ( (lv_expressions_7_0= ruleArithmeticExpression ) )
            	    // InternalFLY.g:2717:5: (lv_expressions_7_0= ruleArithmeticExpression )
            	    {
            	    // InternalFLY.g:2717:5: (lv_expressions_7_0= ruleArithmeticExpression )
            	    // InternalFLY.g:2718:6: lv_expressions_7_0= ruleArithmeticExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getVariableFunctionAccess().getExpressionsArithmeticExpressionParserRuleCall_6_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_expressions_7_0=ruleArithmeticExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getVariableFunctionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_7_0,
            	      							"org.xtext.FLY.ArithmeticExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_8=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getVariableFunctionAccess().getRightParenthesisKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableFunction"


    // $ANTLR start "entryRuleFunctionReturn"
    // InternalFLY.g:2744:1: entryRuleFunctionReturn returns [EObject current=null] : iv_ruleFunctionReturn= ruleFunctionReturn EOF ;
    public final EObject entryRuleFunctionReturn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionReturn = null;


        try {
            // InternalFLY.g:2744:55: (iv_ruleFunctionReturn= ruleFunctionReturn EOF )
            // InternalFLY.g:2745:2: iv_ruleFunctionReturn= ruleFunctionReturn EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionReturnRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionReturn=ruleFunctionReturn();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionReturn; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionReturn"


    // $ANTLR start "ruleFunctionReturn"
    // InternalFLY.g:2751:1: ruleFunctionReturn returns [EObject current=null] : ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleArithmeticExpression ) ) ) ;
    public final EObject ruleFunctionReturn() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:2757:2: ( ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleArithmeticExpression ) ) ) )
            // InternalFLY.g:2758:2: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleArithmeticExpression ) ) )
            {
            // InternalFLY.g:2758:2: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleArithmeticExpression ) ) )
            // InternalFLY.g:2759:3: () otherlv_1= 'return' ( (lv_expression_2_0= ruleArithmeticExpression ) )
            {
            // InternalFLY.g:2759:3: ()
            // InternalFLY.g:2760:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFunctionReturnAccess().getFunctionReturnAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,42,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionReturnAccess().getReturnKeyword_1());
              		
            }
            // InternalFLY.g:2770:3: ( (lv_expression_2_0= ruleArithmeticExpression ) )
            // InternalFLY.g:2771:4: (lv_expression_2_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:2771:4: (lv_expression_2_0= ruleArithmeticExpression )
            // InternalFLY.g:2772:5: lv_expression_2_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionReturnAccess().getExpressionArithmeticExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_2_0=ruleArithmeticExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionReturnRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"org.xtext.FLY.ArithmeticExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionReturn"


    // $ANTLR start "entryRuleFunctionDefinition"
    // InternalFLY.g:2793:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalFLY.g:2793:59: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalFLY.g:2794:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDefinition"


    // $ANTLR start "ruleFunctionDefinition"
    // InternalFLY.g:2800:1: ruleFunctionDefinition returns [EObject current=null] : ( () otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParams ) )? (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )* otherlv_7= ')' ( (lv_body_8_0= ruleBlockExpression ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_parameters_4_0 = null;

        EObject lv_parameters_6_0 = null;

        EObject lv_body_8_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:2806:2: ( ( () otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParams ) )? (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )* otherlv_7= ')' ( (lv_body_8_0= ruleBlockExpression ) ) ) )
            // InternalFLY.g:2807:2: ( () otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParams ) )? (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )* otherlv_7= ')' ( (lv_body_8_0= ruleBlockExpression ) ) )
            {
            // InternalFLY.g:2807:2: ( () otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParams ) )? (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )* otherlv_7= ')' ( (lv_body_8_0= ruleBlockExpression ) ) )
            // InternalFLY.g:2808:3: () otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParams ) )? (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )* otherlv_7= ')' ( (lv_body_8_0= ruleBlockExpression ) )
            {
            // InternalFLY.g:2808:3: ()
            // InternalFLY.g:2809:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFunctionDefinitionAccess().getFunctionDefinitionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,43,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getFuncKeyword_1());
              		
            }
            // InternalFLY.g:2819:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalFLY.g:2820:4: (lv_name_2_0= RULE_ID )
            {
            // InternalFLY.g:2820:4: (lv_name_2_0= RULE_ID )
            // InternalFLY.g:2821:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.xtext.FLY.ID");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalFLY.g:2841:3: ( (lv_parameters_4_0= ruleParams ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalFLY.g:2842:4: (lv_parameters_4_0= ruleParams )
                    {
                    // InternalFLY.g:2842:4: (lv_parameters_4_0= ruleParams )
                    // InternalFLY.g:2843:5: lv_parameters_4_0= ruleParams
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParamsParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_30);
                    lv_parameters_4_0=ruleParams();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                      					}
                      					add(
                      						current,
                      						"parameters",
                      						lv_parameters_4_0,
                      						"org.xtext.FLY.Params");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalFLY.g:2860:3: (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==37) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalFLY.g:2861:4: otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) )
            	    {
            	    otherlv_5=(Token)match(input,37,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_5_0());
            	      			
            	    }
            	    // InternalFLY.g:2865:4: ( (lv_parameters_6_0= ruleParams ) )
            	    // InternalFLY.g:2866:5: (lv_parameters_6_0= ruleParams )
            	    {
            	    // InternalFLY.g:2866:5: (lv_parameters_6_0= ruleParams )
            	    // InternalFLY.g:2867:6: lv_parameters_6_0= ruleParams
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParamsParserRuleCall_5_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_parameters_6_0=ruleParams();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"parameters",
            	      							lv_parameters_6_0,
            	      							"org.xtext.FLY.Params");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            otherlv_7=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalFLY.g:2889:3: ( (lv_body_8_0= ruleBlockExpression ) )
            // InternalFLY.g:2890:4: (lv_body_8_0= ruleBlockExpression )
            {
            // InternalFLY.g:2890:4: (lv_body_8_0= ruleBlockExpression )
            // InternalFLY.g:2891:5: lv_body_8_0= ruleBlockExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getBodyBlockExpressionParserRuleCall_7_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_8_0=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_8_0,
              						"org.xtext.FLY.BlockExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDefinition"


    // $ANTLR start "entryRuleParams"
    // InternalFLY.g:2912:1: entryRuleParams returns [EObject current=null] : iv_ruleParams= ruleParams EOF ;
    public final EObject entryRuleParams() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParams = null;


        try {
            // InternalFLY.g:2912:47: (iv_ruleParams= ruleParams EOF )
            // InternalFLY.g:2913:2: iv_ruleParams= ruleParams EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParams=ruleParams();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParams; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParams"


    // $ANTLR start "ruleParams"
    // InternalFLY.g:2919:1: ruleParams returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParams() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFLY.g:2925:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFLY.g:2926:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFLY.g:2926:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFLY.g:2927:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalFLY.g:2927:3: ()
            // InternalFLY.g:2928:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParamsAccess().getVariableDeclarationAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:2934:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFLY.g:2935:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFLY.g:2935:4: (lv_name_1_0= RULE_ID )
            // InternalFLY.g:2936:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getParamsAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getParamsRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.xtext.FLY.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParams"


    // $ANTLR start "entryRuleChannelSend"
    // InternalFLY.g:2956:1: entryRuleChannelSend returns [EObject current=null] : iv_ruleChannelSend= ruleChannelSend EOF ;
    public final EObject entryRuleChannelSend() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChannelSend = null;


        try {
            // InternalFLY.g:2956:52: (iv_ruleChannelSend= ruleChannelSend EOF )
            // InternalFLY.g:2957:2: iv_ruleChannelSend= ruleChannelSend EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getChannelSendRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleChannelSend=ruleChannelSend();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleChannelSend; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChannelSend"


    // $ANTLR start "ruleChannelSend"
    // InternalFLY.g:2963:1: ruleChannelSend returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '!' ( (lv_expression_3_0= ruleArithmeticExpression ) ) ) ;
    public final EObject ruleChannelSend() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:2969:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '!' ( (lv_expression_3_0= ruleArithmeticExpression ) ) ) )
            // InternalFLY.g:2970:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '!' ( (lv_expression_3_0= ruleArithmeticExpression ) ) )
            {
            // InternalFLY.g:2970:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '!' ( (lv_expression_3_0= ruleArithmeticExpression ) ) )
            // InternalFLY.g:2971:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '!' ( (lv_expression_3_0= ruleArithmeticExpression ) )
            {
            // InternalFLY.g:2971:3: ()
            // InternalFLY.g:2972:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getChannelSendAccess().getChannelSendAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:2978:3: ( (otherlv_1= RULE_ID ) )
            // InternalFLY.g:2979:4: (otherlv_1= RULE_ID )
            {
            // InternalFLY.g:2979:4: (otherlv_1= RULE_ID )
            // InternalFLY.g:2980:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getChannelSendRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getChannelSendAccess().getTargetChannelDeclarationCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,44,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getChannelSendAccess().getExclamationMarkKeyword_2());
              		
            }
            // InternalFLY.g:2995:3: ( (lv_expression_3_0= ruleArithmeticExpression ) )
            // InternalFLY.g:2996:4: (lv_expression_3_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:2996:4: (lv_expression_3_0= ruleArithmeticExpression )
            // InternalFLY.g:2997:5: lv_expression_3_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getChannelSendAccess().getExpressionArithmeticExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_3_0=ruleArithmeticExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getChannelSendRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_3_0,
              						"org.xtext.FLY.ArithmeticExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChannelSend"


    // $ANTLR start "entryRuleChannelReceive"
    // InternalFLY.g:3018:1: entryRuleChannelReceive returns [EObject current=null] : iv_ruleChannelReceive= ruleChannelReceive EOF ;
    public final EObject entryRuleChannelReceive() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChannelReceive = null;


        try {
            // InternalFLY.g:3018:55: (iv_ruleChannelReceive= ruleChannelReceive EOF )
            // InternalFLY.g:3019:2: iv_ruleChannelReceive= ruleChannelReceive EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getChannelReceiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleChannelReceive=ruleChannelReceive();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleChannelReceive; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChannelReceive"


    // $ANTLR start "ruleChannelReceive"
    // InternalFLY.g:3025:1: ruleChannelReceive returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '?' ) ;
    public final EObject ruleChannelReceive() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalFLY.g:3031:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '?' ) )
            // InternalFLY.g:3032:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '?' )
            {
            // InternalFLY.g:3032:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '?' )
            // InternalFLY.g:3033:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '?'
            {
            // InternalFLY.g:3033:3: ()
            // InternalFLY.g:3034:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getChannelReceiveAccess().getChannelReceiveAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:3040:3: ( (otherlv_1= RULE_ID ) )
            // InternalFLY.g:3041:4: (otherlv_1= RULE_ID )
            {
            // InternalFLY.g:3041:4: (otherlv_1= RULE_ID )
            // InternalFLY.g:3042:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getChannelReceiveRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getChannelReceiveAccess().getTargetChannelDeclarationCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getChannelReceiveAccess().getQuestionMarkKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChannelReceive"


    // $ANTLR start "entryRuleLocalFunctionCall"
    // InternalFLY.g:3061:1: entryRuleLocalFunctionCall returns [EObject current=null] : iv_ruleLocalFunctionCall= ruleLocalFunctionCall EOF ;
    public final EObject entryRuleLocalFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalFunctionCall = null;


        try {
            // InternalFLY.g:3061:58: (iv_ruleLocalFunctionCall= ruleLocalFunctionCall EOF )
            // InternalFLY.g:3062:2: iv_ruleLocalFunctionCall= ruleLocalFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLocalFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLocalFunctionCall=ruleLocalFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLocalFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalFunctionCall"


    // $ANTLR start "ruleLocalFunctionCall"
    // InternalFLY.g:3068:1: ruleLocalFunctionCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_input_3_0= ruleLocalFunctionInput ) ) otherlv_4= ')' ) ;
    public final EObject ruleLocalFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_input_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3074:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_input_3_0= ruleLocalFunctionInput ) ) otherlv_4= ')' ) )
            // InternalFLY.g:3075:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_input_3_0= ruleLocalFunctionInput ) ) otherlv_4= ')' )
            {
            // InternalFLY.g:3075:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_input_3_0= ruleLocalFunctionInput ) ) otherlv_4= ')' )
            // InternalFLY.g:3076:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_input_3_0= ruleLocalFunctionInput ) ) otherlv_4= ')'
            {
            // InternalFLY.g:3076:3: ()
            // InternalFLY.g:3077:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLocalFunctionCallAccess().getLocalFunctionCallAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:3083:3: ( (otherlv_1= RULE_ID ) )
            // InternalFLY.g:3084:4: (otherlv_1= RULE_ID )
            {
            // InternalFLY.g:3084:4: (otherlv_1= RULE_ID )
            // InternalFLY.g:3085:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLocalFunctionCallRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getLocalFunctionCallAccess().getTargetFunctionDefinitionCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLocalFunctionCallAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalFLY.g:3100:3: ( (lv_input_3_0= ruleLocalFunctionInput ) )
            // InternalFLY.g:3101:4: (lv_input_3_0= ruleLocalFunctionInput )
            {
            // InternalFLY.g:3101:4: (lv_input_3_0= ruleLocalFunctionInput )
            // InternalFLY.g:3102:5: lv_input_3_0= ruleLocalFunctionInput
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLocalFunctionCallAccess().getInputLocalFunctionInputParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_input_3_0=ruleLocalFunctionInput();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLocalFunctionCallRule());
              					}
              					set(
              						current,
              						"input",
              						lv_input_3_0,
              						"org.xtext.FLY.LocalFunctionInput");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLocalFunctionCallAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalFunctionCall"


    // $ANTLR start "entryRuleLocalFunctionInput"
    // InternalFLY.g:3127:1: entryRuleLocalFunctionInput returns [EObject current=null] : iv_ruleLocalFunctionInput= ruleLocalFunctionInput EOF ;
    public final EObject entryRuleLocalFunctionInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalFunctionInput = null;


        try {
            // InternalFLY.g:3127:59: (iv_ruleLocalFunctionInput= ruleLocalFunctionInput EOF )
            // InternalFLY.g:3128:2: iv_ruleLocalFunctionInput= ruleLocalFunctionInput EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLocalFunctionInputRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLocalFunctionInput=ruleLocalFunctionInput();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLocalFunctionInput; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalFunctionInput"


    // $ANTLR start "ruleLocalFunctionInput"
    // InternalFLY.g:3134:1: ruleLocalFunctionInput returns [EObject current=null] : ( () ( (lv_inputs_1_0= ruleArithmeticExpression ) )? (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )* ) ;
    public final EObject ruleLocalFunctionInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_inputs_1_0 = null;

        EObject lv_inputs_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3140:2: ( ( () ( (lv_inputs_1_0= ruleArithmeticExpression ) )? (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )* ) )
            // InternalFLY.g:3141:2: ( () ( (lv_inputs_1_0= ruleArithmeticExpression ) )? (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )* )
            {
            // InternalFLY.g:3141:2: ( () ( (lv_inputs_1_0= ruleArithmeticExpression ) )? (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )* )
            // InternalFLY.g:3142:3: () ( (lv_inputs_1_0= ruleArithmeticExpression ) )? (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )*
            {
            // InternalFLY.g:3142:3: ()
            // InternalFLY.g:3143:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLocalFunctionInputAccess().getLocalFunctionInputAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:3149:3: ( (lv_inputs_1_0= ruleArithmeticExpression ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_FLOAT)||LA26_0==21||LA26_0==36||LA26_0==41||(LA26_0>=58 && LA26_0<=59)||LA26_0==62||(LA26_0>=73 && LA26_0<=75)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalFLY.g:3150:4: (lv_inputs_1_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:3150:4: (lv_inputs_1_0= ruleArithmeticExpression )
                    // InternalFLY.g:3151:5: lv_inputs_1_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLocalFunctionInputAccess().getInputsArithmeticExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_34);
                    lv_inputs_1_0=ruleArithmeticExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getLocalFunctionInputRule());
                      					}
                      					add(
                      						current,
                      						"inputs",
                      						lv_inputs_1_0,
                      						"org.xtext.FLY.ArithmeticExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalFLY.g:3168:3: (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==37) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalFLY.g:3169:4: otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,37,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLocalFunctionInputAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalFLY.g:3173:4: ( (lv_inputs_3_0= ruleArithmeticExpression ) )
            	    // InternalFLY.g:3174:5: (lv_inputs_3_0= ruleArithmeticExpression )
            	    {
            	    // InternalFLY.g:3174:5: (lv_inputs_3_0= ruleArithmeticExpression )
            	    // InternalFLY.g:3175:6: lv_inputs_3_0= ruleArithmeticExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLocalFunctionInputAccess().getInputsArithmeticExpressionParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_inputs_3_0=ruleArithmeticExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLocalFunctionInputRule());
            	      						}
            	      						add(
            	      							current,
            	      							"inputs",
            	      							lv_inputs_3_0,
            	      							"org.xtext.FLY.ArithmeticExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalFunctionInput"


    // $ANTLR start "entryRuleFlyFunctionCall"
    // InternalFLY.g:3197:1: entryRuleFlyFunctionCall returns [EObject current=null] : iv_ruleFlyFunctionCall= ruleFlyFunctionCall EOF ;
    public final EObject entryRuleFlyFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlyFunctionCall = null;


        try {
            // InternalFLY.g:3197:56: (iv_ruleFlyFunctionCall= ruleFlyFunctionCall EOF )
            // InternalFLY.g:3198:2: iv_ruleFlyFunctionCall= ruleFlyFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlyFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFlyFunctionCall=ruleFlyFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlyFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlyFunctionCall"


    // $ANTLR start "ruleFlyFunctionCall"
    // InternalFLY.g:3204:1: ruleFlyFunctionCall returns [EObject current=null] : ( () ( (lv_isAsync_1_0= 'async' ) )? otherlv_2= 'fly' ( (otherlv_3= RULE_ID ) ) ( (lv_input_4_0= ruleFunctionInput ) )? otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )? ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )? ) ;
    public final EObject ruleFlyFunctionCall() throws RecognitionException {
        EObject current = null;

        Token lv_isAsync_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_is_then_7_0=null;
        Token otherlv_8=null;
        Token lv_is_thenall_9_0=null;
        Token otherlv_10=null;
        EObject lv_input_4_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3210:2: ( ( () ( (lv_isAsync_1_0= 'async' ) )? otherlv_2= 'fly' ( (otherlv_3= RULE_ID ) ) ( (lv_input_4_0= ruleFunctionInput ) )? otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )? ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )? ) )
            // InternalFLY.g:3211:2: ( () ( (lv_isAsync_1_0= 'async' ) )? otherlv_2= 'fly' ( (otherlv_3= RULE_ID ) ) ( (lv_input_4_0= ruleFunctionInput ) )? otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )? ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )? )
            {
            // InternalFLY.g:3211:2: ( () ( (lv_isAsync_1_0= 'async' ) )? otherlv_2= 'fly' ( (otherlv_3= RULE_ID ) ) ( (lv_input_4_0= ruleFunctionInput ) )? otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )? ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )? )
            // InternalFLY.g:3212:3: () ( (lv_isAsync_1_0= 'async' ) )? otherlv_2= 'fly' ( (otherlv_3= RULE_ID ) ) ( (lv_input_4_0= ruleFunctionInput ) )? otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )? ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )?
            {
            // InternalFLY.g:3212:3: ()
            // InternalFLY.g:3213:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFlyFunctionCallAccess().getFlyFunctionCallAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:3219:3: ( (lv_isAsync_1_0= 'async' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==46) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalFLY.g:3220:4: (lv_isAsync_1_0= 'async' )
                    {
                    // InternalFLY.g:3220:4: (lv_isAsync_1_0= 'async' )
                    // InternalFLY.g:3221:5: lv_isAsync_1_0= 'async'
                    {
                    lv_isAsync_1_0=(Token)match(input,46,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_isAsync_1_0, grammarAccess.getFlyFunctionCallAccess().getIsAsyncAsyncKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFlyFunctionCallRule());
                      					}
                      					setWithLastConsumed(current, "isAsync", true, "async");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,47,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFlyFunctionCallAccess().getFlyKeyword_2());
              		
            }
            // InternalFLY.g:3237:3: ( (otherlv_3= RULE_ID ) )
            // InternalFLY.g:3238:4: (otherlv_3= RULE_ID )
            {
            // InternalFLY.g:3238:4: (otherlv_3= RULE_ID )
            // InternalFLY.g:3239:5: otherlv_3= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFlyFunctionCallRule());
              					}
              				
            }
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_3, grammarAccess.getFlyFunctionCallAccess().getTargetFunctionDefinitionCrossReference_3_0());
              				
            }

            }


            }

            // InternalFLY.g:3250:3: ( (lv_input_4_0= ruleFunctionInput ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==21||LA29_0==25) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalFLY.g:3251:4: (lv_input_4_0= ruleFunctionInput )
                    {
                    // InternalFLY.g:3251:4: (lv_input_4_0= ruleFunctionInput )
                    // InternalFLY.g:3252:5: lv_input_4_0= ruleFunctionInput
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFlyFunctionCallAccess().getInputFunctionInputParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_7);
                    lv_input_4_0=ruleFunctionInput();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFlyFunctionCallRule());
                      					}
                      					set(
                      						current,
                      						"input",
                      						lv_input_4_0,
                      						"org.xtext.FLY.FunctionInput");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFlyFunctionCallAccess().getOnKeyword_5());
              		
            }
            // InternalFLY.g:3273:3: ( (otherlv_6= RULE_ID ) )
            // InternalFLY.g:3274:4: (otherlv_6= RULE_ID )
            {
            // InternalFLY.g:3274:4: (otherlv_6= RULE_ID )
            // InternalFLY.g:3275:5: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFlyFunctionCallRule());
              					}
              				
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_6, grammarAccess.getFlyFunctionCallAccess().getEnvironmentEnvironmentDeclarationCrossReference_6_0());
              				
            }

            }


            }

            // InternalFLY.g:3286:3: ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==48) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalFLY.g:3287:4: ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalFLY.g:3287:4: ( (lv_is_then_7_0= 'then' ) )
                    // InternalFLY.g:3288:5: (lv_is_then_7_0= 'then' )
                    {
                    // InternalFLY.g:3288:5: (lv_is_then_7_0= 'then' )
                    // InternalFLY.g:3289:6: lv_is_then_7_0= 'then'
                    {
                    lv_is_then_7_0=(Token)match(input,48,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_is_then_7_0, grammarAccess.getFlyFunctionCallAccess().getIs_thenThenKeyword_7_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFlyFunctionCallRule());
                      						}
                      						setWithLastConsumed(current, "is_then", true, "then");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:3301:4: ( (otherlv_8= RULE_ID ) )
                    // InternalFLY.g:3302:5: (otherlv_8= RULE_ID )
                    {
                    // InternalFLY.g:3302:5: (otherlv_8= RULE_ID )
                    // InternalFLY.g:3303:6: otherlv_8= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFlyFunctionCallRule());
                      						}
                      					
                    }
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_8, grammarAccess.getFlyFunctionCallAccess().getThenFunctionDefinitionCrossReference_7_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalFLY.g:3315:3: ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==49) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalFLY.g:3316:4: ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalFLY.g:3316:4: ( (lv_is_thenall_9_0= 'thenall' ) )
                    // InternalFLY.g:3317:5: (lv_is_thenall_9_0= 'thenall' )
                    {
                    // InternalFLY.g:3317:5: (lv_is_thenall_9_0= 'thenall' )
                    // InternalFLY.g:3318:6: lv_is_thenall_9_0= 'thenall'
                    {
                    lv_is_thenall_9_0=(Token)match(input,49,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_is_thenall_9_0, grammarAccess.getFlyFunctionCallAccess().getIs_thenallThenallKeyword_8_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFlyFunctionCallRule());
                      						}
                      						setWithLastConsumed(current, "is_thenall", true, "thenall");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:3330:4: ( (otherlv_10= RULE_ID ) )
                    // InternalFLY.g:3331:5: (otherlv_10= RULE_ID )
                    {
                    // InternalFLY.g:3331:5: (otherlv_10= RULE_ID )
                    // InternalFLY.g:3332:6: otherlv_10= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFlyFunctionCallRule());
                      						}
                      					
                    }
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_10, grammarAccess.getFlyFunctionCallAccess().getThenallFunctionDefinitionCrossReference_8_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlyFunctionCall"


    // $ANTLR start "entryRuleFunctionInput"
    // InternalFLY.g:3348:1: entryRuleFunctionInput returns [EObject current=null] : iv_ruleFunctionInput= ruleFunctionInput EOF ;
    public final EObject entryRuleFunctionInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionInput = null;


        try {
            // InternalFLY.g:3348:54: (iv_ruleFunctionInput= ruleFunctionInput EOF )
            // InternalFLY.g:3349:2: iv_ruleFunctionInput= ruleFunctionInput EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionInputRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionInput=ruleFunctionInput();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionInput; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionInput"


    // $ANTLR start "ruleFunctionInput"
    // InternalFLY.g:3355:1: ruleFunctionInput returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' ) | ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) ) ) ;
    public final EObject ruleFunctionInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_is_for_index_7_0=null;
        EObject lv_expressions_2_0 = null;

        EObject lv_expressions_4_0 = null;

        EObject lv_f_index_8_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3361:2: ( ( ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' ) | ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) ) ) )
            // InternalFLY.g:3362:2: ( ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' ) | ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) ) )
            {
            // InternalFLY.g:3362:2: ( ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' ) | ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==21) ) {
                alt34=1;
            }
            else if ( (LA34_0==25) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalFLY.g:3363:3: ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' )
                    {
                    // InternalFLY.g:3363:3: ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' )
                    // InternalFLY.g:3364:4: () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')'
                    {
                    // InternalFLY.g:3364:4: ()
                    // InternalFLY.g:3365:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getFunctionInputAccess().getFunctionInputAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getFunctionInputAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalFLY.g:3375:4: ( (lv_expressions_2_0= ruleArithmeticExpression ) )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_FLOAT)||LA32_0==21||LA32_0==36||LA32_0==41||(LA32_0>=58 && LA32_0<=59)||LA32_0==62||(LA32_0>=73 && LA32_0<=75)) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalFLY.g:3376:5: (lv_expressions_2_0= ruleArithmeticExpression )
                            {
                            // InternalFLY.g:3376:5: (lv_expressions_2_0= ruleArithmeticExpression )
                            // InternalFLY.g:3377:6: lv_expressions_2_0= ruleArithmeticExpression
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getFunctionInputAccess().getExpressionsArithmeticExpressionParserRuleCall_0_2_0());
                              					
                            }
                            pushFollow(FOLLOW_30);
                            lv_expressions_2_0=ruleArithmeticExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getFunctionInputRule());
                              						}
                              						add(
                              							current,
                              							"expressions",
                              							lv_expressions_2_0,
                              							"org.xtext.FLY.ArithmeticExpression");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalFLY.g:3394:4: (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==37) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalFLY.g:3395:5: otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,37,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getFunctionInputAccess().getCommaKeyword_0_3_0());
                    	      				
                    	    }
                    	    // InternalFLY.g:3399:5: ( (lv_expressions_4_0= ruleArithmeticExpression ) )
                    	    // InternalFLY.g:3400:6: (lv_expressions_4_0= ruleArithmeticExpression )
                    	    {
                    	    // InternalFLY.g:3400:6: (lv_expressions_4_0= ruleArithmeticExpression )
                    	    // InternalFLY.g:3401:7: lv_expressions_4_0= ruleArithmeticExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionInputAccess().getExpressionsArithmeticExpressionParserRuleCall_0_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_30);
                    	    lv_expressions_4_0=ruleArithmeticExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getFunctionInputRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"expressions",
                    	      								lv_expressions_4_0,
                    	      								"org.xtext.FLY.ArithmeticExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getFunctionInputAccess().getRightParenthesisKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:3425:3: ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) )
                    {
                    // InternalFLY.g:3425:3: ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) )
                    // InternalFLY.g:3426:4: () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) )
                    {
                    // InternalFLY.g:3426:4: ()
                    // InternalFLY.g:3427:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getFunctionInputAccess().getFunctionInputAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:3433:4: ( (lv_is_for_index_7_0= 'in' ) )
                    // InternalFLY.g:3434:5: (lv_is_for_index_7_0= 'in' )
                    {
                    // InternalFLY.g:3434:5: (lv_is_for_index_7_0= 'in' )
                    // InternalFLY.g:3435:6: lv_is_for_index_7_0= 'in'
                    {
                    lv_is_for_index_7_0=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_is_for_index_7_0, grammarAccess.getFunctionInputAccess().getIs_for_indexInKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFunctionInputRule());
                      						}
                      						setWithLastConsumed(current, "is_for_index", true, "in");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:3447:4: ( (lv_f_index_8_0= ruleArithmeticExpression ) )
                    // InternalFLY.g:3448:5: (lv_f_index_8_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:3448:5: (lv_f_index_8_0= ruleArithmeticExpression )
                    // InternalFLY.g:3449:6: lv_f_index_8_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionInputAccess().getF_indexArithmeticExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_f_index_8_0=ruleArithmeticExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionInputRule());
                      						}
                      						set(
                      							current,
                      							"f_index",
                      							lv_f_index_8_0,
                      							"org.xtext.FLY.ArithmeticExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionInput"


    // $ANTLR start "entryRuleArithmeticExpression"
    // InternalFLY.g:3471:1: entryRuleArithmeticExpression returns [EObject current=null] : iv_ruleArithmeticExpression= ruleArithmeticExpression EOF ;
    public final EObject entryRuleArithmeticExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmeticExpression = null;


        try {
            // InternalFLY.g:3471:61: (iv_ruleArithmeticExpression= ruleArithmeticExpression EOF )
            // InternalFLY.g:3472:2: iv_ruleArithmeticExpression= ruleArithmeticExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithmeticExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArithmeticExpression=ruleArithmeticExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithmeticExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithmeticExpression"


    // $ANTLR start "ruleArithmeticExpression"
    // InternalFLY.g:3478:1: ruleArithmeticExpression returns [EObject current=null] : this_OrExpression_0= ruleOrExpression ;
    public final EObject ruleArithmeticExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3484:2: (this_OrExpression_0= ruleOrExpression )
            // InternalFLY.g:3485:2: this_OrExpression_0= ruleOrExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getArithmeticExpressionAccess().getOrExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_OrExpression_0=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_OrExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithmeticExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalFLY.g:3496:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalFLY.g:3496:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalFLY.g:3497:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalFLY.g:3503:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3509:2: ( (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalFLY.g:3510:2: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalFLY.g:3510:2: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalFLY.g:3511:3: this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_39);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:3519:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==50) ) {
                    int LA35_2 = input.LA(2);

                    if ( (synpred14_InternalFLY()) ) {
                        alt35=1;
                    }


                }


                switch (alt35) {
            	case 1 :
            	    // InternalFLY.g:3520:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalFLY.g:3520:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) )
            	    // InternalFLY.g:3521:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) )
            	    {
            	    // InternalFLY.g:3531:5: ( () ( (lv_feature_2_0= ruleOpOr ) ) )
            	    // InternalFLY.g:3532:6: () ( (lv_feature_2_0= ruleOpOr ) )
            	    {
            	    // InternalFLY.g:3532:6: ()
            	    // InternalFLY.g:3533:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:3539:6: ( (lv_feature_2_0= ruleOpOr ) )
            	    // InternalFLY.g:3540:7: (lv_feature_2_0= ruleOpOr )
            	    {
            	    // InternalFLY.g:3540:7: (lv_feature_2_0= ruleOpOr )
            	    // InternalFLY.g:3541:8: lv_feature_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getOrExpressionAccess().getFeatureOpOrParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_feature_2_0=ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.xtext.FLY.OpOr");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalFLY.g:3560:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalFLY.g:3561:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalFLY.g:3561:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalFLY.g:3562:6: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.FLY.AndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // InternalFLY.g:3584:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalFLY.g:3584:44: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalFLY.g:3585:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // InternalFLY.g:3591:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'or' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:3597:2: (kw= 'or' )
            // InternalFLY.g:3598:2: kw= 'or'
            {
            kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleAndExpression"
    // InternalFLY.g:3606:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalFLY.g:3606:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalFLY.g:3607:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalFLY.g:3613:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3619:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalFLY.g:3620:2: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalFLY.g:3620:2: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalFLY.g:3621:3: this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_40);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:3629:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==51) ) {
                    int LA36_2 = input.LA(2);

                    if ( (synpred15_InternalFLY()) ) {
                        alt36=1;
                    }


                }


                switch (alt36) {
            	case 1 :
            	    // InternalFLY.g:3630:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalFLY.g:3630:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) )
            	    // InternalFLY.g:3631:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) )
            	    {
            	    // InternalFLY.g:3641:5: ( () ( (lv_feature_2_0= ruleOpAnd ) ) )
            	    // InternalFLY.g:3642:6: () ( (lv_feature_2_0= ruleOpAnd ) )
            	    {
            	    // InternalFLY.g:3642:6: ()
            	    // InternalFLY.g:3643:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:3649:6: ( (lv_feature_2_0= ruleOpAnd ) )
            	    // InternalFLY.g:3650:7: (lv_feature_2_0= ruleOpAnd )
            	    {
            	    // InternalFLY.g:3650:7: (lv_feature_2_0= ruleOpAnd )
            	    // InternalFLY.g:3651:8: lv_feature_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAndExpressionAccess().getFeatureOpAndParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_feature_2_0=ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.xtext.FLY.OpAnd");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalFLY.g:3670:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalFLY.g:3671:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalFLY.g:3671:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalFLY.g:3672:6: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
            	    lv_right_3_0=ruleEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.FLY.EqualityExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // InternalFLY.g:3694:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalFLY.g:3694:45: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalFLY.g:3695:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // InternalFLY.g:3701:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'and' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:3707:2: (kw= 'and' )
            // InternalFLY.g:3708:2: kw= 'and'
            {
            kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalFLY.g:3716:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalFLY.g:3716:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalFLY.g:3717:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalFLY.g:3723:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3729:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalFLY.g:3730:2: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalFLY.g:3730:2: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // InternalFLY.g:3731:3: this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_41);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:3739:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==52) ) {
                    int LA37_2 = input.LA(2);

                    if ( (synpred16_InternalFLY()) ) {
                        alt37=1;
                    }


                }
                else if ( (LA37_0==53) ) {
                    int LA37_3 = input.LA(2);

                    if ( (synpred16_InternalFLY()) ) {
                        alt37=1;
                    }


                }


                switch (alt37) {
            	case 1 :
            	    // InternalFLY.g:3740:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
            	    {
            	    // InternalFLY.g:3740:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) )
            	    // InternalFLY.g:3741:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) )
            	    {
            	    // InternalFLY.g:3751:5: ( () ( (lv_feature_2_0= ruleOpEquality ) ) )
            	    // InternalFLY.g:3752:6: () ( (lv_feature_2_0= ruleOpEquality ) )
            	    {
            	    // InternalFLY.g:3752:6: ()
            	    // InternalFLY.g:3753:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:3759:6: ( (lv_feature_2_0= ruleOpEquality ) )
            	    // InternalFLY.g:3760:7: (lv_feature_2_0= ruleOpEquality )
            	    {
            	    // InternalFLY.g:3760:7: (lv_feature_2_0= ruleOpEquality )
            	    // InternalFLY.g:3761:8: lv_feature_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getEqualityExpressionAccess().getFeatureOpEqualityParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_feature_2_0=ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.xtext.FLY.OpEquality");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalFLY.g:3780:4: ( (lv_right_3_0= ruleRelationalExpression ) )
            	    // InternalFLY.g:3781:5: (lv_right_3_0= ruleRelationalExpression )
            	    {
            	    // InternalFLY.g:3781:5: (lv_right_3_0= ruleRelationalExpression )
            	    // InternalFLY.g:3782:6: lv_right_3_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_41);
            	    lv_right_3_0=ruleRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.FLY.RelationalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // InternalFLY.g:3804:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalFLY.g:3804:50: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalFLY.g:3805:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // InternalFLY.g:3811:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:3817:2: ( (kw= '==' | kw= '!=' ) )
            // InternalFLY.g:3818:2: (kw= '==' | kw= '!=' )
            {
            // InternalFLY.g:3818:2: (kw= '==' | kw= '!=' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==52) ) {
                alt38=1;
            }
            else if ( (LA38_0==53) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalFLY.g:3819:3: kw= '=='
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:3825:3: kw= '!='
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalFLY.g:3834:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalFLY.g:3834:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalFLY.g:3835:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalFLY.g:3841:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3847:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalFLY.g:3848:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalFLY.g:3848:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalFLY.g:3849:3: this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_42);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:3857:3: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                switch ( input.LA(1) ) {
                case 54:
                    {
                    int LA39_2 = input.LA(2);

                    if ( (synpred17_InternalFLY()) ) {
                        alt39=1;
                    }


                    }
                    break;
                case 55:
                    {
                    int LA39_3 = input.LA(2);

                    if ( (synpred17_InternalFLY()) ) {
                        alt39=1;
                    }


                    }
                    break;
                case 56:
                    {
                    int LA39_4 = input.LA(2);

                    if ( (synpred17_InternalFLY()) ) {
                        alt39=1;
                    }


                    }
                    break;
                case 57:
                    {
                    int LA39_5 = input.LA(2);

                    if ( (synpred17_InternalFLY()) ) {
                        alt39=1;
                    }


                    }
                    break;

                }

                switch (alt39) {
            	case 1 :
            	    // InternalFLY.g:3858:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalFLY.g:3858:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) )
            	    // InternalFLY.g:3859:5: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) )
            	    {
            	    // InternalFLY.g:3869:5: ( () ( (lv_feature_2_0= ruleOpCompare ) ) )
            	    // InternalFLY.g:3870:6: () ( (lv_feature_2_0= ruleOpCompare ) )
            	    {
            	    // InternalFLY.g:3870:6: ()
            	    // InternalFLY.g:3871:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:3877:6: ( (lv_feature_2_0= ruleOpCompare ) )
            	    // InternalFLY.g:3878:7: (lv_feature_2_0= ruleOpCompare )
            	    {
            	    // InternalFLY.g:3878:7: (lv_feature_2_0= ruleOpCompare )
            	    // InternalFLY.g:3879:8: lv_feature_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getRelationalExpressionAccess().getFeatureOpCompareParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_feature_2_0=ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.xtext.FLY.OpCompare");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalFLY.g:3898:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalFLY.g:3899:5: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalFLY.g:3899:5: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalFLY.g:3900:6: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
            	    lv_right_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.FLY.AdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // InternalFLY.g:3922:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalFLY.g:3922:49: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalFLY.g:3923:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // InternalFLY.g:3929:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '<' | kw= '>' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:3935:2: ( (kw= '>=' | kw= '<=' | kw= '<' | kw= '>' ) )
            // InternalFLY.g:3936:2: (kw= '>=' | kw= '<=' | kw= '<' | kw= '>' )
            {
            // InternalFLY.g:3936:2: (kw= '>=' | kw= '<=' | kw= '<' | kw= '>' )
            int alt40=4;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt40=1;
                }
                break;
            case 55:
                {
                alt40=2;
                }
                break;
            case 56:
                {
                alt40=3;
                }
                break;
            case 57:
                {
                alt40=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalFLY.g:3937:3: kw= '>='
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:3943:3: kw= '<='
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalFLY.g:3949:3: kw= '<'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalFLY.g:3955:3: kw= '>'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalFLY.g:3964:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalFLY.g:3964:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalFLY.g:3965:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalFLY.g:3971:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3977:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalFLY.g:3978:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalFLY.g:3978:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalFLY.g:3979:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_43);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:3987:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==58) ) {
                    int LA41_2 = input.LA(2);

                    if ( (synpred18_InternalFLY()) ) {
                        alt41=1;
                    }


                }
                else if ( (LA41_0==59) ) {
                    int LA41_3 = input.LA(2);

                    if ( (synpred18_InternalFLY()) ) {
                        alt41=1;
                    }


                }


                switch (alt41) {
            	case 1 :
            	    // InternalFLY.g:3988:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalFLY.g:3988:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) )
            	    // InternalFLY.g:3989:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    {
            	    // InternalFLY.g:3999:5: ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    // InternalFLY.g:4000:6: () ( (lv_feature_2_0= ruleOpAdd ) )
            	    {
            	    // InternalFLY.g:4000:6: ()
            	    // InternalFLY.g:4001:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:4007:6: ( (lv_feature_2_0= ruleOpAdd ) )
            	    // InternalFLY.g:4008:7: (lv_feature_2_0= ruleOpAdd )
            	    {
            	    // InternalFLY.g:4008:7: (lv_feature_2_0= ruleOpAdd )
            	    // InternalFLY.g:4009:8: lv_feature_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getFeatureOpAddParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_feature_2_0=ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.xtext.FLY.OpAdd");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalFLY.g:4028:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    // InternalFLY.g:4029:5: (lv_right_3_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalFLY.g:4029:5: (lv_right_3_0= ruleMultiplicativeExpression )
            	    // InternalFLY.g:4030:6: lv_right_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_43);
            	    lv_right_3_0=ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.FLY.MultiplicativeExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // InternalFLY.g:4052:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalFLY.g:4052:45: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalFLY.g:4053:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // InternalFLY.g:4059:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4065:2: ( (kw= '+' | kw= '-' ) )
            // InternalFLY.g:4066:2: (kw= '+' | kw= '-' )
            {
            // InternalFLY.g:4066:2: (kw= '+' | kw= '-' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==58) ) {
                alt42=1;
            }
            else if ( (LA42_0==59) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalFLY.g:4067:3: kw= '+'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4073:3: kw= '-'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalFLY.g:4082:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalFLY.g:4082:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalFLY.g:4083:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalFLY.g:4089:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:4095:2: ( (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) )
            // InternalFLY.g:4096:2: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            {
            // InternalFLY.g:4096:2: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            // InternalFLY.g:4097:3: this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getUnaryOperationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_44);
            this_UnaryOperation_0=ruleUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_UnaryOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:4105:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==60) ) {
                    int LA43_2 = input.LA(2);

                    if ( (synpred19_InternalFLY()) ) {
                        alt43=1;
                    }


                }
                else if ( (LA43_0==61) ) {
                    int LA43_3 = input.LA(2);

                    if ( (synpred19_InternalFLY()) ) {
                        alt43=1;
                    }


                }


                switch (alt43) {
            	case 1 :
            	    // InternalFLY.g:4106:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) )
            	    {
            	    // InternalFLY.g:4106:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) )
            	    // InternalFLY.g:4107:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    {
            	    // InternalFLY.g:4117:5: ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    // InternalFLY.g:4118:6: () ( (lv_feature_2_0= ruleOpMulti ) )
            	    {
            	    // InternalFLY.g:4118:6: ()
            	    // InternalFLY.g:4119:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:4125:6: ( (lv_feature_2_0= ruleOpMulti ) )
            	    // InternalFLY.g:4126:7: (lv_feature_2_0= ruleOpMulti )
            	    {
            	    // InternalFLY.g:4126:7: (lv_feature_2_0= ruleOpMulti )
            	    // InternalFLY.g:4127:8: lv_feature_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getFeatureOpMultiParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_feature_2_0=ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.xtext.FLY.OpMulti");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalFLY.g:4146:4: ( (lv_right_3_0= ruleUnaryOperation ) )
            	    // InternalFLY.g:4147:5: (lv_right_3_0= ruleUnaryOperation )
            	    {
            	    // InternalFLY.g:4147:5: (lv_right_3_0= ruleUnaryOperation )
            	    // InternalFLY.g:4148:6: lv_right_3_0= ruleUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightUnaryOperationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_44);
            	    lv_right_3_0=ruleUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.FLY.UnaryOperation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // InternalFLY.g:4170:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalFLY.g:4170:47: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalFLY.g:4171:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // InternalFLY.g:4177:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4183:2: ( (kw= '*' | kw= '/' ) )
            // InternalFLY.g:4184:2: (kw= '*' | kw= '/' )
            {
            // InternalFLY.g:4184:2: (kw= '*' | kw= '/' )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==60) ) {
                alt44=1;
            }
            else if ( (LA44_0==61) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalFLY.g:4185:3: kw= '*'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4191:3: kw= '/'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleUnaryOperation"
    // InternalFLY.g:4200:1: entryRuleUnaryOperation returns [EObject current=null] : iv_ruleUnaryOperation= ruleUnaryOperation EOF ;
    public final EObject entryRuleUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperation = null;


        try {
            // InternalFLY.g:4200:55: (iv_ruleUnaryOperation= ruleUnaryOperation EOF )
            // InternalFLY.g:4201:2: iv_ruleUnaryOperation= ruleUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryOperation=ruleUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperation"


    // $ANTLR start "ruleUnaryOperation"
    // InternalFLY.g:4207:1: ruleUnaryOperation returns [EObject current=null] : ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) ) | this_CastExpression_3= ruleCastExpression ) ;
    public final EObject ruleUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_feature_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_CastExpression_3 = null;



        	enterRule();

        try {
            // InternalFLY.g:4213:2: ( ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) ) | this_CastExpression_3= ruleCastExpression ) )
            // InternalFLY.g:4214:2: ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) ) | this_CastExpression_3= ruleCastExpression )
            {
            // InternalFLY.g:4214:2: ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) ) | this_CastExpression_3= ruleCastExpression )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=58 && LA45_0<=59)||LA45_0==62) ) {
                alt45=1;
            }
            else if ( ((LA45_0>=RULE_ID && LA45_0<=RULE_FLOAT)||LA45_0==21||LA45_0==36||LA45_0==41||(LA45_0>=73 && LA45_0<=75)) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalFLY.g:4215:3: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) )
                    {
                    // InternalFLY.g:4215:3: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) )
                    // InternalFLY.g:4216:4: () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) )
                    {
                    // InternalFLY.g:4216:4: ()
                    // InternalFLY.g:4217:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:4223:4: ( (lv_feature_1_0= ruleOpUnary ) )
                    // InternalFLY.g:4224:5: (lv_feature_1_0= ruleOpUnary )
                    {
                    // InternalFLY.g:4224:5: (lv_feature_1_0= ruleOpUnary )
                    // InternalFLY.g:4225:6: lv_feature_1_0= ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryOperationAccess().getFeatureOpUnaryParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_9);
                    lv_feature_1_0=ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryOperationRule());
                      						}
                      						set(
                      							current,
                      							"feature",
                      							lv_feature_1_0,
                      							"org.xtext.FLY.OpUnary");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalFLY.g:4242:4: ( (lv_operand_2_0= ruleUnaryOperation ) )
                    // InternalFLY.g:4243:5: (lv_operand_2_0= ruleUnaryOperation )
                    {
                    // InternalFLY.g:4243:5: (lv_operand_2_0= ruleUnaryOperation )
                    // InternalFLY.g:4244:6: lv_operand_2_0= ruleUnaryOperation
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryOperationAccess().getOperandUnaryOperationParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleUnaryOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryOperationRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.xtext.FLY.UnaryOperation");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:4263:3: this_CastExpression_3= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryOperationAccess().getCastExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CastExpression_3=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CastExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // InternalFLY.g:4275:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalFLY.g:4275:47: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalFLY.g:4276:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // InternalFLY.g:4282:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4288:2: ( (kw= 'not' | kw= '-' | kw= '+' ) )
            // InternalFLY.g:4289:2: (kw= 'not' | kw= '-' | kw= '+' )
            {
            // InternalFLY.g:4289:2: (kw= 'not' | kw= '-' | kw= '+' )
            int alt46=3;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt46=1;
                }
                break;
            case 59:
                {
                alt46=2;
                }
                break;
            case 58:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalFLY.g:4290:3: kw= 'not'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4296:3: kw= '-'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalFLY.g:4302:3: kw= '+'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleCastExpression"
    // InternalFLY.g:4311:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalFLY.g:4311:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalFLY.g:4312:2: iv_ruleCastExpression= ruleCastExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCastExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCastExpression=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCastExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCastExpression"


    // $ANTLR start "ruleCastExpression"
    // InternalFLY.g:4318:1: ruleCastExpression returns [EObject current=null] : (this_PostfixOperation_0= rulePostfixOperation ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )* ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_PostfixOperation_0 = null;

        AntlrDatatypeRuleToken lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:4324:2: ( (this_PostfixOperation_0= rulePostfixOperation ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )* ) )
            // InternalFLY.g:4325:2: (this_PostfixOperation_0= rulePostfixOperation ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )* )
            {
            // InternalFLY.g:4325:2: (this_PostfixOperation_0= rulePostfixOperation ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )* )
            // InternalFLY.g:4326:3: this_PostfixOperation_0= rulePostfixOperation ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCastExpressionAccess().getPostfixOperationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_45);
            this_PostfixOperation_0=rulePostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PostfixOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:4334:3: ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==63) ) {
                    int LA48_2 = input.LA(2);

                    if ( (synpred20_InternalFLY()) ) {
                        alt48=1;
                    }


                }
                else if ( (LA48_0==64) ) {
                    int LA48_3 = input.LA(2);

                    if ( (synpred20_InternalFLY()) ) {
                        alt48=1;
                    }


                }


                switch (alt48) {
            	case 1 :
            	    // InternalFLY.g:4335:4: ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) )
            	    {
            	    // InternalFLY.g:4335:4: ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) )
            	    // InternalFLY.g:4336:5: ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) )
            	    {
            	    // InternalFLY.g:4350:5: ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) )
            	    // InternalFLY.g:4351:6: () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) )
            	    {
            	    // InternalFLY.g:4351:6: ()
            	    // InternalFLY.g:4352:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getCastExpressionAccess().getCastExpressionTargetAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:4358:6: ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) )
            	    // InternalFLY.g:4359:7: ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) )
            	    {
            	    // InternalFLY.g:4359:7: ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) )
            	    // InternalFLY.g:4360:8: (lv_op_2_1= 'as' | lv_op_2_2= 'parse' )
            	    {
            	    // InternalFLY.g:4360:8: (lv_op_2_1= 'as' | lv_op_2_2= 'parse' )
            	    int alt47=2;
            	    int LA47_0 = input.LA(1);

            	    if ( (LA47_0==63) ) {
            	        alt47=1;
            	    }
            	    else if ( (LA47_0==64) ) {
            	        alt47=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 47, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt47) {
            	        case 1 :
            	            // InternalFLY.g:4361:9: lv_op_2_1= 'as'
            	            {
            	            lv_op_2_1=(Token)match(input,63,FOLLOW_46); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              									newLeafNode(lv_op_2_1, grammarAccess.getCastExpressionAccess().getOpAsKeyword_1_0_0_1_0_0());
            	              								
            	            }
            	            if ( state.backtracking==0 ) {

            	              									if (current==null) {
            	              										current = createModelElement(grammarAccess.getCastExpressionRule());
            	              									}
            	              									setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              								
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalFLY.g:4372:9: lv_op_2_2= 'parse'
            	            {
            	            lv_op_2_2=(Token)match(input,64,FOLLOW_46); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              									newLeafNode(lv_op_2_2, grammarAccess.getCastExpressionAccess().getOpParseKeyword_1_0_0_1_0_1());
            	              								
            	            }
            	            if ( state.backtracking==0 ) {

            	              									if (current==null) {
            	              										current = createModelElement(grammarAccess.getCastExpressionRule());
            	              									}
            	              									setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              								
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	    // InternalFLY.g:4387:4: ( (lv_type_3_0= ruleType ) )
            	    // InternalFLY.g:4388:5: (lv_type_3_0= ruleType )
            	    {
            	    // InternalFLY.g:4388:5: (lv_type_3_0= ruleType )
            	    // InternalFLY.g:4389:6: lv_type_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeTypeParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_45);
            	    lv_type_3_0=ruleType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"type",
            	      							lv_type_3_0,
            	      							"org.xtext.FLY.Type");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCastExpression"


    // $ANTLR start "entryRuleType"
    // InternalFLY.g:4411:1: entryRuleType returns [String current=null] : iv_ruleType= ruleType EOF ;
    public final String entryRuleType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType = null;


        try {
            // InternalFLY.g:4411:44: (iv_ruleType= ruleType EOF )
            // InternalFLY.g:4412:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalFLY.g:4418:1: ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'String' | kw= 'Integer' | kw= 'Date' | kw= 'Dat' | kw= 'Object' | kw= 'Double' ) ;
    public final AntlrDatatypeRuleToken ruleType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4424:2: ( (kw= 'String' | kw= 'Integer' | kw= 'Date' | kw= 'Dat' | kw= 'Object' | kw= 'Double' ) )
            // InternalFLY.g:4425:2: (kw= 'String' | kw= 'Integer' | kw= 'Date' | kw= 'Dat' | kw= 'Object' | kw= 'Double' )
            {
            // InternalFLY.g:4425:2: (kw= 'String' | kw= 'Integer' | kw= 'Date' | kw= 'Dat' | kw= 'Object' | kw= 'Double' )
            int alt49=6;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt49=1;
                }
                break;
            case 66:
                {
                alt49=2;
                }
                break;
            case 67:
                {
                alt49=3;
                }
                break;
            case 68:
                {
                alt49=4;
                }
                break;
            case 69:
                {
                alt49=5;
                }
                break;
            case 70:
                {
                alt49=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalFLY.g:4426:3: kw= 'String'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeAccess().getStringKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4432:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeAccess().getIntegerKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalFLY.g:4438:3: kw= 'Date'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeAccess().getDateKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalFLY.g:4444:3: kw= 'Dat'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeAccess().getDatKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalFLY.g:4450:3: kw= 'Object'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeAccess().getObjectKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalFLY.g:4456:3: kw= 'Double'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeAccess().getDoubleKeyword_5());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRulePostfixOperation"
    // InternalFLY.g:4465:1: entryRulePostfixOperation returns [EObject current=null] : iv_rulePostfixOperation= rulePostfixOperation EOF ;
    public final EObject entryRulePostfixOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOperation = null;


        try {
            // InternalFLY.g:4465:57: (iv_rulePostfixOperation= rulePostfixOperation EOF )
            // InternalFLY.g:4466:2: iv_rulePostfixOperation= rulePostfixOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostfixOperation=rulePostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostfixOperation"


    // $ANTLR start "rulePostfixOperation"
    // InternalFLY.g:4472:1: rulePostfixOperation returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpPostfix ) ) ) )? ) ;
    public final EObject rulePostfixOperation() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:4478:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpPostfix ) ) ) )? ) )
            // InternalFLY.g:4479:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpPostfix ) ) ) )? )
            {
            // InternalFLY.g:4479:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpPostfix ) ) ) )? )
            // InternalFLY.g:4480:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpPostfix ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPostfixOperationAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_47);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:4488:3: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpPostfix ) ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==71) ) {
                int LA50_1 = input.LA(2);

                if ( (synpred21_InternalFLY()) ) {
                    alt50=1;
                }
            }
            else if ( (LA50_0==72) ) {
                int LA50_2 = input.LA(2);

                if ( (synpred21_InternalFLY()) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // InternalFLY.g:4489:4: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpPostfix ) ) )
                    {
                    // InternalFLY.g:4499:4: ( () ( (lv_feature_2_0= ruleOpPostfix ) ) )
                    // InternalFLY.g:4500:5: () ( (lv_feature_2_0= ruleOpPostfix ) )
                    {
                    // InternalFLY.g:4500:5: ()
                    // InternalFLY.g:4501:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndSet(
                      							grammarAccess.getPostfixOperationAccess().getPostfixOperationOperandAction_1_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalFLY.g:4507:5: ( (lv_feature_2_0= ruleOpPostfix ) )
                    // InternalFLY.g:4508:6: (lv_feature_2_0= ruleOpPostfix )
                    {
                    // InternalFLY.g:4508:6: (lv_feature_2_0= ruleOpPostfix )
                    // InternalFLY.g:4509:7: lv_feature_2_0= ruleOpPostfix
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPostfixOperationAccess().getFeatureOpPostfixParserRuleCall_1_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_feature_2_0=ruleOpPostfix();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPostfixOperationRule());
                      							}
                      							set(
                      								current,
                      								"feature",
                      								lv_feature_2_0,
                      								"org.xtext.FLY.OpPostfix");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePostfixOperation"


    // $ANTLR start "entryRuleOpPostfix"
    // InternalFLY.g:4532:1: entryRuleOpPostfix returns [String current=null] : iv_ruleOpPostfix= ruleOpPostfix EOF ;
    public final String entryRuleOpPostfix() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpPostfix = null;


        try {
            // InternalFLY.g:4532:49: (iv_ruleOpPostfix= ruleOpPostfix EOF )
            // InternalFLY.g:4533:2: iv_ruleOpPostfix= ruleOpPostfix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpPostfixRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpPostfix=ruleOpPostfix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpPostfix.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpPostfix"


    // $ANTLR start "ruleOpPostfix"
    // InternalFLY.g:4539:1: ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' | kw= '--' ) ;
    public final AntlrDatatypeRuleToken ruleOpPostfix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4545:2: ( (kw= '++' | kw= '--' ) )
            // InternalFLY.g:4546:2: (kw= '++' | kw= '--' )
            {
            // InternalFLY.g:4546:2: (kw= '++' | kw= '--' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==71) ) {
                alt51=1;
            }
            else if ( (LA51_0==72) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalFLY.g:4547:3: kw= '++'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4553:3: kw= '--'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpPostfix"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalFLY.g:4562:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalFLY.g:4562:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalFLY.g:4563:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalFLY.g:4569:1: rulePrimaryExpression returns [EObject current=null] : (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_LiteralExpression_1= ruleLiteralExpression | this_LocalFunctionCall_2= ruleLocalFunctionCall | this_MathFunction_3= ruleMathFunction | this_ChannelSend_4= ruleChannelSend | this_ChannelReceive_5= ruleChannelReceive | this_TimeFunction_6= ruleTimeFunction | this_VariableFunction_7= ruleVariableFunction ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ParenthesizedExpression_0 = null;

        EObject this_LiteralExpression_1 = null;

        EObject this_LocalFunctionCall_2 = null;

        EObject this_MathFunction_3 = null;

        EObject this_ChannelSend_4 = null;

        EObject this_ChannelReceive_5 = null;

        EObject this_TimeFunction_6 = null;

        EObject this_VariableFunction_7 = null;



        	enterRule();

        try {
            // InternalFLY.g:4575:2: ( (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_LiteralExpression_1= ruleLiteralExpression | this_LocalFunctionCall_2= ruleLocalFunctionCall | this_MathFunction_3= ruleMathFunction | this_ChannelSend_4= ruleChannelSend | this_ChannelReceive_5= ruleChannelReceive | this_TimeFunction_6= ruleTimeFunction | this_VariableFunction_7= ruleVariableFunction ) )
            // InternalFLY.g:4576:2: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_LiteralExpression_1= ruleLiteralExpression | this_LocalFunctionCall_2= ruleLocalFunctionCall | this_MathFunction_3= ruleMathFunction | this_ChannelSend_4= ruleChannelSend | this_ChannelReceive_5= ruleChannelReceive | this_TimeFunction_6= ruleTimeFunction | this_VariableFunction_7= ruleVariableFunction )
            {
            // InternalFLY.g:4576:2: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_LiteralExpression_1= ruleLiteralExpression | this_LocalFunctionCall_2= ruleLocalFunctionCall | this_MathFunction_3= ruleMathFunction | this_ChannelSend_4= ruleChannelSend | this_ChannelReceive_5= ruleChannelReceive | this_TimeFunction_6= ruleTimeFunction | this_VariableFunction_7= ruleVariableFunction )
            int alt52=8;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // InternalFLY.g:4577:3: this_ParenthesizedExpression_0= ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParenthesizedExpression_0=ruleParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParenthesizedExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4586:3: this_LiteralExpression_1= ruleLiteralExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralExpression_1=ruleLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalFLY.g:4595:3: this_LocalFunctionCall_2= ruleLocalFunctionCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLocalFunctionCallParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LocalFunctionCall_2=ruleLocalFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LocalFunctionCall_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalFLY.g:4604:3: this_MathFunction_3= ruleMathFunction
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getMathFunctionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_MathFunction_3=ruleMathFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_MathFunction_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalFLY.g:4613:3: this_ChannelSend_4= ruleChannelSend
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getChannelSendParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ChannelSend_4=ruleChannelSend();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ChannelSend_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalFLY.g:4622:3: this_ChannelReceive_5= ruleChannelReceive
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getChannelReceiveParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ChannelReceive_5=ruleChannelReceive();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ChannelReceive_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalFLY.g:4631:3: this_TimeFunction_6= ruleTimeFunction
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getTimeFunctionParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TimeFunction_6=ruleTimeFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TimeFunction_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalFLY.g:4640:3: this_VariableFunction_7= ruleVariableFunction
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getVariableFunctionParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableFunction_7=ruleVariableFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableFunction_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleLiteralExpression"
    // InternalFLY.g:4652:1: entryRuleLiteralExpression returns [EObject current=null] : iv_ruleLiteralExpression= ruleLiteralExpression EOF ;
    public final EObject entryRuleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpression = null;


        try {
            // InternalFLY.g:4652:58: (iv_ruleLiteralExpression= ruleLiteralExpression EOF )
            // InternalFLY.g:4653:2: iv_ruleLiteralExpression= ruleLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralExpression=ruleLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralExpression"


    // $ANTLR start "ruleLiteralExpression"
    // InternalFLY.g:4659:1: ruleLiteralExpression returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral | this_ObjectLiteral_3= ruleObjectLiteral | this_VariableLiteral_4= ruleVariableLiteral | this_RangeLiteral_5= ruleRangeLiteral | this_FloatLiteral_6= ruleFloatLiteral ) ;
    public final EObject ruleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;

        EObject this_ObjectLiteral_3 = null;

        EObject this_VariableLiteral_4 = null;

        EObject this_RangeLiteral_5 = null;

        EObject this_FloatLiteral_6 = null;



        	enterRule();

        try {
            // InternalFLY.g:4665:2: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral | this_ObjectLiteral_3= ruleObjectLiteral | this_VariableLiteral_4= ruleVariableLiteral | this_RangeLiteral_5= ruleRangeLiteral | this_FloatLiteral_6= ruleFloatLiteral ) )
            // InternalFLY.g:4666:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral | this_ObjectLiteral_3= ruleObjectLiteral | this_VariableLiteral_4= ruleVariableLiteral | this_RangeLiteral_5= ruleRangeLiteral | this_FloatLiteral_6= ruleFloatLiteral )
            {
            // InternalFLY.g:4666:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral | this_ObjectLiteral_3= ruleObjectLiteral | this_VariableLiteral_4= ruleVariableLiteral | this_RangeLiteral_5= ruleRangeLiteral | this_FloatLiteral_6= ruleFloatLiteral )
            int alt53=7;
            switch ( input.LA(1) ) {
            case 74:
            case 75:
                {
                alt53=1;
                }
                break;
            case RULE_INT:
                {
                alt53=2;
                }
                break;
            case RULE_STRING:
                {
                alt53=3;
                }
                break;
            case RULE_ID:
                {
                int LA53_4 = input.LA(2);

                if ( (LA53_4==36||LA53_4==40) ) {
                    alt53=4;
                }
                else if ( (LA53_4==EOF||LA53_4==RULE_ID||(LA53_4>=12 && LA53_4<=13)||LA53_4==16||(LA53_4>=19 && LA53_4<=20)||(LA53_4>=22 && LA53_4<=24)||(LA53_4>=26 && LA53_4<=35)||(LA53_4>=37 && LA53_4<=38)||(LA53_4>=42 && LA53_4<=43)||(LA53_4>=46 && LA53_4<=47)||(LA53_4>=50 && LA53_4<=61)||(LA53_4>=63 && LA53_4<=64)||(LA53_4>=71 && LA53_4<=72)) ) {
                    alt53=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 4, input);

                    throw nvae;
                }
                }
                break;
            case 36:
                {
                alt53=6;
                }
                break;
            case RULE_FLOAT:
                {
                alt53=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalFLY.g:4667:3: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getBooleanLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4676:3: this_NumberLiteral_1= ruleNumberLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getNumberLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NumberLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalFLY.g:4685:3: this_StringLiteral_2= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getStringLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_2=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringLiteral_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalFLY.g:4694:3: this_ObjectLiteral_3= ruleObjectLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getObjectLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ObjectLiteral_3=ruleObjectLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ObjectLiteral_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalFLY.g:4703:3: this_VariableLiteral_4= ruleVariableLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getVariableLiteralParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableLiteral_4=ruleVariableLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableLiteral_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalFLY.g:4712:3: this_RangeLiteral_5= ruleRangeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getRangeLiteralParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RangeLiteral_5=ruleRangeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RangeLiteral_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalFLY.g:4721:3: this_FloatLiteral_6= ruleFloatLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getFloatLiteralParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FloatLiteral_6=ruleFloatLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FloatLiteral_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralExpression"


    // $ANTLR start "entryRuleTimeFunction"
    // InternalFLY.g:4733:1: entryRuleTimeFunction returns [EObject current=null] : iv_ruleTimeFunction= ruleTimeFunction EOF ;
    public final EObject entryRuleTimeFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeFunction = null;


        try {
            // InternalFLY.g:4733:53: (iv_ruleTimeFunction= ruleTimeFunction EOF )
            // InternalFLY.g:4734:2: iv_ruleTimeFunction= ruleTimeFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTimeFunction=ruleTimeFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTimeFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeFunction"


    // $ANTLR start "ruleTimeFunction"
    // InternalFLY.g:4740:1: ruleTimeFunction returns [EObject current=null] : ( () otherlv_1= 'time' otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' ) ;
    public final EObject ruleTimeFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalFLY.g:4746:2: ( ( () otherlv_1= 'time' otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' ) )
            // InternalFLY.g:4747:2: ( () otherlv_1= 'time' otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' )
            {
            // InternalFLY.g:4747:2: ( () otherlv_1= 'time' otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' )
            // InternalFLY.g:4748:3: () otherlv_1= 'time' otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')'
            {
            // InternalFLY.g:4748:3: ()
            // InternalFLY.g:4749:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTimeFunctionAccess().getTimeFunctionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,73,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTimeFunctionAccess().getTimeKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,21,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getTimeFunctionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalFLY.g:4763:3: ( (otherlv_3= RULE_ID ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalFLY.g:4764:4: (otherlv_3= RULE_ID )
            	    {
            	    // InternalFLY.g:4764:4: (otherlv_3= RULE_ID )
            	    // InternalFLY.g:4765:5: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElement(grammarAccess.getTimeFunctionRule());
            	      					}
            	      				
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_48); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_3, grammarAccess.getTimeFunctionAccess().getValueVariableDeclarationCrossReference_3_0());
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getTimeFunctionAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeFunction"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalFLY.g:4784:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalFLY.g:4784:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalFLY.g:4785:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalFLY.g:4791:1: ruleBooleanLiteral returns [EObject current=null] : ( ( () ( (lv_value_1_0= 'false' ) ) ) | ( () ( (lv_value_3_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalFLY.g:4797:2: ( ( ( () ( (lv_value_1_0= 'false' ) ) ) | ( () ( (lv_value_3_0= 'true' ) ) ) ) )
            // InternalFLY.g:4798:2: ( ( () ( (lv_value_1_0= 'false' ) ) ) | ( () ( (lv_value_3_0= 'true' ) ) ) )
            {
            // InternalFLY.g:4798:2: ( ( () ( (lv_value_1_0= 'false' ) ) ) | ( () ( (lv_value_3_0= 'true' ) ) ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==74) ) {
                alt55=1;
            }
            else if ( (LA55_0==75) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalFLY.g:4799:3: ( () ( (lv_value_1_0= 'false' ) ) )
                    {
                    // InternalFLY.g:4799:3: ( () ( (lv_value_1_0= 'false' ) ) )
                    // InternalFLY.g:4800:4: () ( (lv_value_1_0= 'false' ) )
                    {
                    // InternalFLY.g:4800:4: ()
                    // InternalFLY.g:4801:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:4807:4: ( (lv_value_1_0= 'false' ) )
                    // InternalFLY.g:4808:5: (lv_value_1_0= 'false' )
                    {
                    // InternalFLY.g:4808:5: (lv_value_1_0= 'false' )
                    // InternalFLY.g:4809:6: lv_value_1_0= 'false'
                    {
                    lv_value_1_0=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueFalseKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBooleanLiteralRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_1_0, "false");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:4823:3: ( () ( (lv_value_3_0= 'true' ) ) )
                    {
                    // InternalFLY.g:4823:3: ( () ( (lv_value_3_0= 'true' ) ) )
                    // InternalFLY.g:4824:4: () ( (lv_value_3_0= 'true' ) )
                    {
                    // InternalFLY.g:4824:4: ()
                    // InternalFLY.g:4825:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:4831:4: ( (lv_value_3_0= 'true' ) )
                    // InternalFLY.g:4832:5: (lv_value_3_0= 'true' )
                    {
                    // InternalFLY.g:4832:5: (lv_value_3_0= 'true' )
                    // InternalFLY.g:4833:6: lv_value_3_0= 'true'
                    {
                    lv_value_3_0=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBooleanLiteralRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_3_0, "true");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleNumberLiteral"
    // InternalFLY.g:4850:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalFLY.g:4850:54: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalFLY.g:4851:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // InternalFLY.g:4857:1: ruleNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalFLY.g:4863:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalFLY.g:4864:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalFLY.g:4864:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // InternalFLY.g:4865:3: () ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalFLY.g:4865:3: ()
            // InternalFLY.g:4866:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getNumberLiteralAccess().getNumberLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:4872:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalFLY.g:4873:4: (lv_value_1_0= RULE_INT )
            {
            // InternalFLY.g:4873:4: (lv_value_1_0= RULE_INT )
            // InternalFLY.g:4874:5: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getNumberLiteralAccess().getValueINTTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getNumberLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.eclipse.xtext.common.Terminals.INT");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalFLY.g:4894:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalFLY.g:4894:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalFLY.g:4895:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalFLY.g:4901:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalFLY.g:4907:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalFLY.g:4908:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalFLY.g:4908:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalFLY.g:4909:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalFLY.g:4909:3: ()
            // InternalFLY.g:4910:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:4916:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalFLY.g:4917:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalFLY.g:4917:4: (lv_value_1_0= RULE_STRING )
            // InternalFLY.g:4918:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStringLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleFloatLiteral"
    // InternalFLY.g:4938:1: entryRuleFloatLiteral returns [EObject current=null] : iv_ruleFloatLiteral= ruleFloatLiteral EOF ;
    public final EObject entryRuleFloatLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatLiteral = null;


        try {
            // InternalFLY.g:4938:53: (iv_ruleFloatLiteral= ruleFloatLiteral EOF )
            // InternalFLY.g:4939:2: iv_ruleFloatLiteral= ruleFloatLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFloatLiteral=ruleFloatLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloatLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloatLiteral"


    // $ANTLR start "ruleFloatLiteral"
    // InternalFLY.g:4945:1: ruleFloatLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) ;
    public final EObject ruleFloatLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalFLY.g:4951:2: ( ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) )
            // InternalFLY.g:4952:2: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            {
            // InternalFLY.g:4952:2: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            // InternalFLY.g:4953:3: () ( (lv_value_1_0= RULE_FLOAT ) )
            {
            // InternalFLY.g:4953:3: ()
            // InternalFLY.g:4954:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFloatLiteralAccess().getFloatLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:4960:3: ( (lv_value_1_0= RULE_FLOAT ) )
            // InternalFLY.g:4961:4: (lv_value_1_0= RULE_FLOAT )
            {
            // InternalFLY.g:4961:4: (lv_value_1_0= RULE_FLOAT )
            // InternalFLY.g:4962:5: lv_value_1_0= RULE_FLOAT
            {
            lv_value_1_0=(Token)match(input,RULE_FLOAT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getFloatLiteralAccess().getValueFLOATTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFloatLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.xtext.FLY.FLOAT");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloatLiteral"


    // $ANTLR start "entryRuleVariableLiteral"
    // InternalFLY.g:4982:1: entryRuleVariableLiteral returns [EObject current=null] : iv_ruleVariableLiteral= ruleVariableLiteral EOF ;
    public final EObject entryRuleVariableLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableLiteral = null;


        try {
            // InternalFLY.g:4982:56: (iv_ruleVariableLiteral= ruleVariableLiteral EOF )
            // InternalFLY.g:4983:2: iv_ruleVariableLiteral= ruleVariableLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableLiteral=ruleVariableLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableLiteral"


    // $ANTLR start "ruleVariableLiteral"
    // InternalFLY.g:4989:1: ruleVariableLiteral returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleVariableLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalFLY.g:4995:2: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // InternalFLY.g:4996:2: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalFLY.g:4996:2: ( () ( (otherlv_1= RULE_ID ) ) )
            // InternalFLY.g:4997:3: () ( (otherlv_1= RULE_ID ) )
            {
            // InternalFLY.g:4997:3: ()
            // InternalFLY.g:4998:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableLiteralAccess().getVariableLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:5004:3: ( (otherlv_1= RULE_ID ) )
            // InternalFLY.g:5005:4: (otherlv_1= RULE_ID )
            {
            // InternalFLY.g:5005:4: (otherlv_1= RULE_ID )
            // InternalFLY.g:5006:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableLiteralRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getVariableLiteralAccess().getVariableVariableDeclarationCrossReference_1_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableLiteral"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // InternalFLY.g:5021:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // InternalFLY.g:5021:64: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // InternalFLY.g:5022:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // InternalFLY.g:5028:1: ruleParenthesizedExpression returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_expression_2_0= ruleArithmeticExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:5034:2: ( ( () otherlv_1= '(' ( (lv_expression_2_0= ruleArithmeticExpression ) ) otherlv_3= ')' ) )
            // InternalFLY.g:5035:2: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleArithmeticExpression ) ) otherlv_3= ')' )
            {
            // InternalFLY.g:5035:2: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleArithmeticExpression ) ) otherlv_3= ')' )
            // InternalFLY.g:5036:3: () otherlv_1= '(' ( (lv_expression_2_0= ruleArithmeticExpression ) ) otherlv_3= ')'
            {
            // InternalFLY.g:5036:3: ()
            // InternalFLY.g:5037:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParenthesizedExpressionAccess().getParenthesizedExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,21,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalFLY.g:5047:3: ( (lv_expression_2_0= ruleArithmeticExpression ) )
            // InternalFLY.g:5048:4: (lv_expression_2_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:5048:4: (lv_expression_2_0= ruleArithmeticExpression )
            // InternalFLY.g:5049:5: lv_expression_2_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionArithmeticExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_expression_2_0=ruleArithmeticExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParenthesizedExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"org.xtext.FLY.ArithmeticExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedExpression"

    // $ANTLR start synpred1_InternalFLY
    public final void synpred1_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:694:5: ( 'else' )
        // InternalFLY.g:694:6: 'else'
        {
        match(input,23,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalFLY

    // $ANTLR start synpred14_InternalFLY
    public final void synpred14_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:3521:5: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalFLY.g:3521:6: ( () ( ( ruleOpOr ) ) )
        {
        // InternalFLY.g:3521:6: ( () ( ( ruleOpOr ) ) )
        // InternalFLY.g:3522:6: () ( ( ruleOpOr ) )
        {
        // InternalFLY.g:3522:6: ()
        // InternalFLY.g:3523:6: 
        {
        }

        // InternalFLY.g:3524:6: ( ( ruleOpOr ) )
        // InternalFLY.g:3525:7: ( ruleOpOr )
        {
        // InternalFLY.g:3525:7: ( ruleOpOr )
        // InternalFLY.g:3526:8: ruleOpOr
        {
        pushFollow(FOLLOW_2);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred14_InternalFLY

    // $ANTLR start synpred15_InternalFLY
    public final void synpred15_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:3631:5: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalFLY.g:3631:6: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalFLY.g:3631:6: ( () ( ( ruleOpAnd ) ) )
        // InternalFLY.g:3632:6: () ( ( ruleOpAnd ) )
        {
        // InternalFLY.g:3632:6: ()
        // InternalFLY.g:3633:6: 
        {
        }

        // InternalFLY.g:3634:6: ( ( ruleOpAnd ) )
        // InternalFLY.g:3635:7: ( ruleOpAnd )
        {
        // InternalFLY.g:3635:7: ( ruleOpAnd )
        // InternalFLY.g:3636:8: ruleOpAnd
        {
        pushFollow(FOLLOW_2);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred15_InternalFLY

    // $ANTLR start synpred16_InternalFLY
    public final void synpred16_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:3741:5: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalFLY.g:3741:6: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalFLY.g:3741:6: ( () ( ( ruleOpEquality ) ) )
        // InternalFLY.g:3742:6: () ( ( ruleOpEquality ) )
        {
        // InternalFLY.g:3742:6: ()
        // InternalFLY.g:3743:6: 
        {
        }

        // InternalFLY.g:3744:6: ( ( ruleOpEquality ) )
        // InternalFLY.g:3745:7: ( ruleOpEquality )
        {
        // InternalFLY.g:3745:7: ( ruleOpEquality )
        // InternalFLY.g:3746:8: ruleOpEquality
        {
        pushFollow(FOLLOW_2);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalFLY

    // $ANTLR start synpred17_InternalFLY
    public final void synpred17_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:3859:5: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalFLY.g:3859:6: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalFLY.g:3859:6: ( () ( ( ruleOpCompare ) ) )
        // InternalFLY.g:3860:6: () ( ( ruleOpCompare ) )
        {
        // InternalFLY.g:3860:6: ()
        // InternalFLY.g:3861:6: 
        {
        }

        // InternalFLY.g:3862:6: ( ( ruleOpCompare ) )
        // InternalFLY.g:3863:7: ( ruleOpCompare )
        {
        // InternalFLY.g:3863:7: ( ruleOpCompare )
        // InternalFLY.g:3864:8: ruleOpCompare
        {
        pushFollow(FOLLOW_2);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred17_InternalFLY

    // $ANTLR start synpred18_InternalFLY
    public final void synpred18_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:3989:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalFLY.g:3989:6: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalFLY.g:3989:6: ( () ( ( ruleOpAdd ) ) )
        // InternalFLY.g:3990:6: () ( ( ruleOpAdd ) )
        {
        // InternalFLY.g:3990:6: ()
        // InternalFLY.g:3991:6: 
        {
        }

        // InternalFLY.g:3992:6: ( ( ruleOpAdd ) )
        // InternalFLY.g:3993:7: ( ruleOpAdd )
        {
        // InternalFLY.g:3993:7: ( ruleOpAdd )
        // InternalFLY.g:3994:8: ruleOpAdd
        {
        pushFollow(FOLLOW_2);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred18_InternalFLY

    // $ANTLR start synpred19_InternalFLY
    public final void synpred19_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:4107:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalFLY.g:4107:6: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalFLY.g:4107:6: ( () ( ( ruleOpMulti ) ) )
        // InternalFLY.g:4108:6: () ( ( ruleOpMulti ) )
        {
        // InternalFLY.g:4108:6: ()
        // InternalFLY.g:4109:6: 
        {
        }

        // InternalFLY.g:4110:6: ( ( ruleOpMulti ) )
        // InternalFLY.g:4111:7: ( ruleOpMulti )
        {
        // InternalFLY.g:4111:7: ( ruleOpMulti )
        // InternalFLY.g:4112:8: ruleOpMulti
        {
        pushFollow(FOLLOW_2);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred19_InternalFLY

    // $ANTLR start synpred20_InternalFLY
    public final void synpred20_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:4336:5: ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )
        // InternalFLY.g:4336:6: ( () ( ( ( 'as' | 'parse' ) ) ) )
        {
        // InternalFLY.g:4336:6: ( () ( ( ( 'as' | 'parse' ) ) ) )
        // InternalFLY.g:4337:6: () ( ( ( 'as' | 'parse' ) ) )
        {
        // InternalFLY.g:4337:6: ()
        // InternalFLY.g:4338:6: 
        {
        }

        // InternalFLY.g:4339:6: ( ( ( 'as' | 'parse' ) ) )
        // InternalFLY.g:4340:7: ( ( 'as' | 'parse' ) )
        {
        // InternalFLY.g:4340:7: ( ( 'as' | 'parse' ) )
        // InternalFLY.g:4341:8: ( 'as' | 'parse' )
        {
        if ( (input.LA(1)>=63 && input.LA(1)<=64) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred20_InternalFLY

    // $ANTLR start synpred21_InternalFLY
    public final void synpred21_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:4489:4: ( ( () ( ( ruleOpPostfix ) ) ) )
        // InternalFLY.g:4489:5: ( () ( ( ruleOpPostfix ) ) )
        {
        // InternalFLY.g:4489:5: ( () ( ( ruleOpPostfix ) ) )
        // InternalFLY.g:4490:5: () ( ( ruleOpPostfix ) )
        {
        // InternalFLY.g:4490:5: ()
        // InternalFLY.g:4491:5: 
        {
        }

        // InternalFLY.g:4492:5: ( ( ruleOpPostfix ) )
        // InternalFLY.g:4493:6: ( ruleOpPostfix )
        {
        // InternalFLY.g:4493:6: ( ruleOpPostfix )
        // InternalFLY.g:4494:7: ruleOpPostfix
        {
        pushFollow(FOLLOW_2);
        ruleOpPostfix();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred21_InternalFLY

    // Delegated rules

    public final boolean synpred15_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalFLY_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalFLY_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalFLY_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalFLY_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalFLY_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalFLY_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalFLY_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalFLY_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalFLY_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA52 dfa52 = new DFA52(this);
    static final String dfa_1s = "\24\uffff";
    static final String dfa_2s = "\1\4\1\21\17\uffff\1\4\1\21\1\uffff";
    static final String dfa_3s = "\1\57\1\55\17\uffff\1\4\1\25\1\uffff";
    static final String dfa_4s = "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\16\1\17\1\14\1\1\1\15\1\13\2\uffff\1\20";
    static final String dfa_5s = "\24\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\7\uffff\1\14\1\13\5\uffff\1\6\1\3\3\uffff\1\4\1\uffff\1\5\1\2\1\uffff\7\12\6\uffff\1\10\1\7\2\uffff\2\11",
            "\2\16\2\uffff\1\17\16\uffff\1\16\3\uffff\1\21\3\uffff\1\20\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\22",
            "\2\16\2\uffff\1\23",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "114:2: (this_Assignment_0= ruleAssignment | this_BlockExpression_1= ruleBlockExpression | this_IfExpression_2= ruleIfExpression | this_ForExpression_3= ruleForExpression | this_WhileExpression_4= ruleWhileExpression | this_PrintExpression_5= rulePrintExpression | this_FunctionDefinition_6= ruleFunctionDefinition | this_FunctionReturn_7= ruleFunctionReturn | this_FlyFunctionCall_8= ruleFlyFunctionCall | this_VariableDeclaration_9= ruleVariableDeclaration | this_ChannelSend_10= ruleChannelSend | this_ChannelReceive_11= ruleChannelReceive | this_LocalFunctionCall_12= ruleLocalFunctionCall | this_SortExpression_13= ruleSortExpression | this_AtomicExpression_14= ruleAtomicExpression | this_VariableFunction_15= ruleVariableFunction )";
        }
    }
    static final String dfa_7s = "\12\uffff";
    static final String dfa_8s = "\1\4\1\44\1\4\2\uffff\1\45\2\uffff\1\5\1\uffff";
    static final String dfa_9s = "\1\4\1\50\1\44\2\uffff\1\46\2\uffff\1\44\1\uffff";
    static final String dfa_10s = "\3\uffff\1\1\1\3\1\uffff\1\4\1\5\1\uffff\1\2";
    static final String dfa_11s = "\12\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\2\3\uffff\1\3",
            "\1\4\1\6\1\5\35\uffff\1\7",
            "",
            "",
            "\1\10\1\11",
            "",
            "",
            "\2\6\35\uffff\1\7",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "2012:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( ( ( '.' ( ( RULE_ID ) ) ) )=> (otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) ) ) | ( () ( (otherlv_5= RULE_ID ) ) ( ( ( '[' ( ( RULE_INT ) ) ']' ) )=> (otherlv_6= '[' ( (lv_valuet_7_0= RULE_INT ) ) otherlv_8= ']' ) ) ) | ( () ( (otherlv_10= RULE_ID ) ) ( ( ( '[' ( ( RULE_ID ) ) ']' ) )=> (otherlv_11= '[' ( (otherlv_12= RULE_ID ) ) otherlv_13= ']' ) ) ) | ( () ( (otherlv_15= RULE_ID ) ) ( ( ( '[' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ',' ( ( ( ruleNumberLiteral | ruleStringLiteral ) ) ) ']' ) )=> (otherlv_16= '[' ( ( (lv_value1_17_1= ruleNumberLiteral | lv_value1_17_2= ruleStringLiteral ) ) ) otherlv_18= ',' ( ( (lv_value2_19_1= ruleNumberLiteral | lv_value2_19_2= ruleStringLiteral ) ) ) otherlv_20= ']' ) ) ) | ( () ( (otherlv_22= RULE_ID ) ) ( ( ( '[' ( ( ( ruleRangeLiteral ) ) | ( ( ruleNumberLiteral ) ) ) ',' ( ( ruleRangeLiteral ) ) ']' ) )=> (otherlv_23= '[' ( ( (lv_range1_24_0= ruleRangeLiteral ) ) | ( (lv_range1_t_25_0= ruleNumberLiteral ) ) ) otherlv_26= ',' ( (lv_range2_27_0= ruleRangeLiteral ) ) otherlv_28= ']' ) ) ) )";
        }
    }
    static final String dfa_13s = "\14\uffff";
    static final String dfa_14s = "\3\uffff\1\2\6\uffff\1\2\1\uffff";
    static final String dfa_15s = "\1\4\2\uffff\1\4\4\uffff\1\4\1\uffff\1\4\1\uffff";
    static final String dfa_16s = "\1\113\2\uffff\1\110\4\uffff\1\4\1\uffff\1\110\1\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\7\1\3\1\5\1\uffff\1\6\1\uffff\1\10";
    static final String dfa_18s = "\14\uffff}>";
    static final String[] dfa_19s = {
            "\1\3\3\2\15\uffff\1\1\16\uffff\1\2\4\uffff\1\4\37\uffff\1\5\2\2",
            "",
            "",
            "\1\2\7\uffff\2\2\2\uffff\1\2\2\uffff\2\2\1\6\3\2\1\uffff\15\2\1\uffff\1\10\1\uffff\2\2\1\7\1\11\2\2\2\uffff\14\2\1\uffff\2\2\6\uffff\2\2",
            "",
            "",
            "",
            "",
            "\1\12",
            "",
            "\1\2\7\uffff\2\2\2\uffff\1\2\2\uffff\2\2\1\13\3\2\1\uffff\12\2\1\uffff\2\2\3\uffff\2\2\2\uffff\2\2\2\uffff\14\2\1\uffff\2\2\6\uffff\2\2",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "4576:2: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_LiteralExpression_1= ruleLiteralExpression | this_LocalFunctionCall_2= ruleLocalFunctionCall | this_MathFunction_3= ruleMathFunction | this_ChannelSend_4= ruleChannelSend | this_ChannelReceive_5= ruleChannelReceive | this_TimeFunction_6= ruleTimeFunction | this_VariableFunction_7= ruleVariableFunction )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000CC0FED183012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x4C00CE1FED3830F0L,0x0000000000000E00L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000CC0FED983010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000CC0FED183010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000CC0FFD183010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x4C00CE7FED3830F0L,0x0000000000000E00L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000070L,0x0000000000000C00L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001000000040L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x4C00CE3FED7830F0L,0x0000000000000E00L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000002000400000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000002000400010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000002210000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x03C0000000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x000000000000007EL});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000400010L});

}