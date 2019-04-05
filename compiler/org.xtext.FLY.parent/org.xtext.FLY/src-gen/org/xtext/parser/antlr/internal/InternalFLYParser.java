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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_NATIVE_CODE", "RULE_FLOAT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'sort'", "'asc'", "'desc'", "'on'", "'='", "'+='", "'println'", "'if'", "'('", "')'", "'else'", "'for'", "'in'", "'by'", "'row'", "'col'", "'delimeter'", "','", "'while'", "'{'", "'}'", "'var'", "'env'", "'dat'", "'random'", "'bin'", "'opt'", "'channel'", "'const'", "'['", "']'", "'.'", "':'", "'Math'", "'return'", "'func'", "'!'", "'?'", "'async'", "'fly'", "'then'", "'thenall'", "'native'", "'require'", "'++'", "'--'", "'or'", "'and'", "'=='", "'!='", "'>='", "'<='", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'not'", "'as'", "'parse'", "'String'", "'Integer'", "'Date'", "'Dat'", "'Object'", "'Double'", "'time'", "'false'", "'true'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
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
    public static final int RULE_ML_COMMENT=9;
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
    public static final int RULE_NATIVE_CODE=7;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=8;
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

                if ( (LA1_0==RULE_ID||LA1_0==13||(LA1_0>=19 && LA1_0<=20)||LA1_0==24||(LA1_0>=31 && LA1_0<=32)||(LA1_0>=34 && LA1_0<=41)||(LA1_0>=47 && LA1_0<=48)||(LA1_0>=51 && LA1_0<=52)||(LA1_0>=55 && LA1_0<=56)) ) {
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
    // InternalFLY.g:107:1: ruleExpression returns [EObject current=null] : (this_Assignment_0= ruleAssignment | this_BlockExpression_1= ruleBlockExpression | this_IfExpression_2= ruleIfExpression | this_ForExpression_3= ruleForExpression | this_WhileExpression_4= ruleWhileExpression | this_PrintExpression_5= rulePrintExpression | this_FunctionDefinition_6= ruleFunctionDefinition | this_FunctionReturn_7= ruleFunctionReturn | this_FlyFunctionCall_8= ruleFlyFunctionCall | this_VariableDeclaration_9= ruleVariableDeclaration | this_ChannelSend_10= ruleChannelSend | this_ChannelReceive_11= ruleChannelReceive | this_LocalFunctionCall_12= ruleLocalFunctionCall | this_SortExpression_13= ruleSortExpression | this_VariableFunction_14= ruleVariableFunction | this_PostfixOperation_15= rulePostfixOperation | this_RequireExpression_16= ruleRequireExpression | this_NativeExpression_17= ruleNativeExpression ) ;
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

        EObject this_VariableFunction_14 = null;

        EObject this_PostfixOperation_15 = null;

        EObject this_RequireExpression_16 = null;

        EObject this_NativeExpression_17 = null;



        	enterRule();

        try {
            // InternalFLY.g:113:2: ( (this_Assignment_0= ruleAssignment | this_BlockExpression_1= ruleBlockExpression | this_IfExpression_2= ruleIfExpression | this_ForExpression_3= ruleForExpression | this_WhileExpression_4= ruleWhileExpression | this_PrintExpression_5= rulePrintExpression | this_FunctionDefinition_6= ruleFunctionDefinition | this_FunctionReturn_7= ruleFunctionReturn | this_FlyFunctionCall_8= ruleFlyFunctionCall | this_VariableDeclaration_9= ruleVariableDeclaration | this_ChannelSend_10= ruleChannelSend | this_ChannelReceive_11= ruleChannelReceive | this_LocalFunctionCall_12= ruleLocalFunctionCall | this_SortExpression_13= ruleSortExpression | this_VariableFunction_14= ruleVariableFunction | this_PostfixOperation_15= rulePostfixOperation | this_RequireExpression_16= ruleRequireExpression | this_NativeExpression_17= ruleNativeExpression ) )
            // InternalFLY.g:114:2: (this_Assignment_0= ruleAssignment | this_BlockExpression_1= ruleBlockExpression | this_IfExpression_2= ruleIfExpression | this_ForExpression_3= ruleForExpression | this_WhileExpression_4= ruleWhileExpression | this_PrintExpression_5= rulePrintExpression | this_FunctionDefinition_6= ruleFunctionDefinition | this_FunctionReturn_7= ruleFunctionReturn | this_FlyFunctionCall_8= ruleFlyFunctionCall | this_VariableDeclaration_9= ruleVariableDeclaration | this_ChannelSend_10= ruleChannelSend | this_ChannelReceive_11= ruleChannelReceive | this_LocalFunctionCall_12= ruleLocalFunctionCall | this_SortExpression_13= ruleSortExpression | this_VariableFunction_14= ruleVariableFunction | this_PostfixOperation_15= rulePostfixOperation | this_RequireExpression_16= ruleRequireExpression | this_NativeExpression_17= ruleNativeExpression )
            {
            // InternalFLY.g:114:2: (this_Assignment_0= ruleAssignment | this_BlockExpression_1= ruleBlockExpression | this_IfExpression_2= ruleIfExpression | this_ForExpression_3= ruleForExpression | this_WhileExpression_4= ruleWhileExpression | this_PrintExpression_5= rulePrintExpression | this_FunctionDefinition_6= ruleFunctionDefinition | this_FunctionReturn_7= ruleFunctionReturn | this_FlyFunctionCall_8= ruleFlyFunctionCall | this_VariableDeclaration_9= ruleVariableDeclaration | this_ChannelSend_10= ruleChannelSend | this_ChannelReceive_11= ruleChannelReceive | this_LocalFunctionCall_12= ruleLocalFunctionCall | this_SortExpression_13= ruleSortExpression | this_VariableFunction_14= ruleVariableFunction | this_PostfixOperation_15= rulePostfixOperation | this_RequireExpression_16= ruleRequireExpression | this_NativeExpression_17= ruleNativeExpression )
            int alt2=18;
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
                    // InternalFLY.g:241:3: this_VariableFunction_14= ruleVariableFunction
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getVariableFunctionParserRuleCall_14());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableFunction_14=ruleVariableFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableFunction_14;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalFLY.g:250:3: this_PostfixOperation_15= rulePostfixOperation
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getPostfixOperationParserRuleCall_15());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PostfixOperation_15=rulePostfixOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostfixOperation_15;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalFLY.g:259:3: this_RequireExpression_16= ruleRequireExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getRequireExpressionParserRuleCall_16());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RequireExpression_16=ruleRequireExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RequireExpression_16;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalFLY.g:268:3: this_NativeExpression_17= ruleNativeExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getNativeExpressionParserRuleCall_17());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NativeExpression_17=ruleNativeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NativeExpression_17;
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


    // $ANTLR start "entryRuleSortExpression"
    // InternalFLY.g:280:1: entryRuleSortExpression returns [EObject current=null] : iv_ruleSortExpression= ruleSortExpression EOF ;
    public final EObject entryRuleSortExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSortExpression = null;


        try {
            // InternalFLY.g:280:55: (iv_ruleSortExpression= ruleSortExpression EOF )
            // InternalFLY.g:281:2: iv_ruleSortExpression= ruleSortExpression EOF
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
    // InternalFLY.g:287:1: ruleSortExpression returns [EObject current=null] : (otherlv_0= 'sort' ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= 'on' ( (lv_taget_4_0= RULE_ID ) ) ) ;
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
            // InternalFLY.g:293:2: ( (otherlv_0= 'sort' ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= 'on' ( (lv_taget_4_0= RULE_ID ) ) ) )
            // InternalFLY.g:294:2: (otherlv_0= 'sort' ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= 'on' ( (lv_taget_4_0= RULE_ID ) ) )
            {
            // InternalFLY.g:294:2: (otherlv_0= 'sort' ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= 'on' ( (lv_taget_4_0= RULE_ID ) ) )
            // InternalFLY.g:295:3: otherlv_0= 'sort' ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= 'on' ( (lv_taget_4_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSortExpressionAccess().getSortKeyword_0());
              		
            }
            // InternalFLY.g:299:3: ( ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) ) )
            // InternalFLY.g:300:4: ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) )
            {
            // InternalFLY.g:300:4: ( (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' ) )
            // InternalFLY.g:301:5: (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' )
            {
            // InternalFLY.g:301:5: (lv_type_1_1= 'asc' | lv_type_1_2= 'desc' )
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
                    // InternalFLY.g:302:6: lv_type_1_1= 'asc'
                    {
                    lv_type_1_1=(Token)match(input,14,FOLLOW_5); if (state.failed) return current;
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
                    // InternalFLY.g:313:6: lv_type_1_2= 'desc'
                    {
                    lv_type_1_2=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
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

            // InternalFLY.g:326:3: ( (otherlv_2= RULE_ID ) )
            // InternalFLY.g:327:4: (otherlv_2= RULE_ID )
            {
            // InternalFLY.g:327:4: (otherlv_2= RULE_ID )
            // InternalFLY.g:328:5: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSortExpressionRule());
              					}
              				
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getSortExpressionAccess().getTargetVariableDeclarationCrossReference_2_0());
              				
            }

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSortExpressionAccess().getOnKeyword_3());
              		
            }
            // InternalFLY.g:343:3: ( (lv_taget_4_0= RULE_ID ) )
            // InternalFLY.g:344:4: (lv_taget_4_0= RULE_ID )
            {
            // InternalFLY.g:344:4: (lv_taget_4_0= RULE_ID )
            // InternalFLY.g:345:5: lv_taget_4_0= RULE_ID
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
    // InternalFLY.g:365:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalFLY.g:365:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalFLY.g:366:2: iv_ruleAssignment= ruleAssignment EOF
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
    // InternalFLY.g:372:1: ruleAssignment returns [EObject current=null] : ( ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) ) | ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) ) ) ;
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
            // InternalFLY.g:378:2: ( ( ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) ) | ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) ) ) )
            // InternalFLY.g:379:2: ( ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) ) | ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) ) )
            {
            // InternalFLY.g:379:2: ( ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) ) | ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( ((LA4_1>=17 && LA4_1<=18)) ) {
                    alt4=1;
                }
                else if ( (LA4_1==42||LA4_1==44) ) {
                    alt4=2;
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
                    // InternalFLY.g:380:3: ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) )
                    {
                    // InternalFLY.g:380:3: ( () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) ) )
                    // InternalFLY.g:381:4: () ( (lv_feature_1_0= ruleVariableLiteral ) ) ( (lv_op_2_0= ruleOpAs ) ) ( (lv_value_3_0= ruleArithmeticExpression ) )
                    {
                    // InternalFLY.g:381:4: ()
                    // InternalFLY.g:382:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAssignmentAccess().getAssignmentAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:388:4: ( (lv_feature_1_0= ruleVariableLiteral ) )
                    // InternalFLY.g:389:5: (lv_feature_1_0= ruleVariableLiteral )
                    {
                    // InternalFLY.g:389:5: (lv_feature_1_0= ruleVariableLiteral )
                    // InternalFLY.g:390:6: lv_feature_1_0= ruleVariableLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getFeatureVariableLiteralParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_7);
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

                    // InternalFLY.g:407:4: ( (lv_op_2_0= ruleOpAs ) )
                    // InternalFLY.g:408:5: (lv_op_2_0= ruleOpAs )
                    {
                    // InternalFLY.g:408:5: (lv_op_2_0= ruleOpAs )
                    // InternalFLY.g:409:6: lv_op_2_0= ruleOpAs
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getOpOpAsParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
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

                    // InternalFLY.g:426:4: ( (lv_value_3_0= ruleArithmeticExpression ) )
                    // InternalFLY.g:427:5: (lv_value_3_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:427:5: (lv_value_3_0= ruleArithmeticExpression )
                    // InternalFLY.g:428:6: lv_value_3_0= ruleArithmeticExpression
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
                    // InternalFLY.g:447:3: ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) )
                    {
                    // InternalFLY.g:447:3: ( () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) ) )
                    // InternalFLY.g:448:4: () ( (lv_feature_obj_5_0= ruleObjectLiteral ) ) ( (lv_op_6_0= ruleOpAs ) ) ( (lv_value_7_0= ruleArithmeticExpression ) )
                    {
                    // InternalFLY.g:448:4: ()
                    // InternalFLY.g:449:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAssignmentAccess().getAssignmentAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:455:4: ( (lv_feature_obj_5_0= ruleObjectLiteral ) )
                    // InternalFLY.g:456:5: (lv_feature_obj_5_0= ruleObjectLiteral )
                    {
                    // InternalFLY.g:456:5: (lv_feature_obj_5_0= ruleObjectLiteral )
                    // InternalFLY.g:457:6: lv_feature_obj_5_0= ruleObjectLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getFeature_objObjectLiteralParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_7);
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

                    // InternalFLY.g:474:4: ( (lv_op_6_0= ruleOpAs ) )
                    // InternalFLY.g:475:5: (lv_op_6_0= ruleOpAs )
                    {
                    // InternalFLY.g:475:5: (lv_op_6_0= ruleOpAs )
                    // InternalFLY.g:476:6: lv_op_6_0= ruleOpAs
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getOpOpAsParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
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

                    // InternalFLY.g:493:4: ( (lv_value_7_0= ruleArithmeticExpression ) )
                    // InternalFLY.g:494:5: (lv_value_7_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:494:5: (lv_value_7_0= ruleArithmeticExpression )
                    // InternalFLY.g:495:6: lv_value_7_0= ruleArithmeticExpression
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
    // InternalFLY.g:517:1: entryRuleOpAs returns [String current=null] : iv_ruleOpAs= ruleOpAs EOF ;
    public final String entryRuleOpAs() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAs = null;


        try {
            // InternalFLY.g:517:44: (iv_ruleOpAs= ruleOpAs EOF )
            // InternalFLY.g:518:2: iv_ruleOpAs= ruleOpAs EOF
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
    // InternalFLY.g:524:1: ruleOpAs returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' ) ;
    public final AntlrDatatypeRuleToken ruleOpAs() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:530:2: ( (kw= '=' | kw= '+=' ) )
            // InternalFLY.g:531:2: (kw= '=' | kw= '+=' )
            {
            // InternalFLY.g:531:2: (kw= '=' | kw= '+=' )
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
                    // InternalFLY.g:532:3: kw= '='
                    {
                    kw=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAsAccess().getEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:538:3: kw= '+='
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
    // InternalFLY.g:547:1: entryRulePrintExpression returns [EObject current=null] : iv_rulePrintExpression= rulePrintExpression EOF ;
    public final EObject entryRulePrintExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrintExpression = null;


        try {
            // InternalFLY.g:547:56: (iv_rulePrintExpression= rulePrintExpression EOF )
            // InternalFLY.g:548:2: iv_rulePrintExpression= rulePrintExpression EOF
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
    // InternalFLY.g:554:1: rulePrintExpression returns [EObject current=null] : ( () otherlv_1= 'println' ( (lv_print_2_0= ruleArithmeticExpression ) ) ) ;
    public final EObject rulePrintExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_print_2_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:560:2: ( ( () otherlv_1= 'println' ( (lv_print_2_0= ruleArithmeticExpression ) ) ) )
            // InternalFLY.g:561:2: ( () otherlv_1= 'println' ( (lv_print_2_0= ruleArithmeticExpression ) ) )
            {
            // InternalFLY.g:561:2: ( () otherlv_1= 'println' ( (lv_print_2_0= ruleArithmeticExpression ) ) )
            // InternalFLY.g:562:3: () otherlv_1= 'println' ( (lv_print_2_0= ruleArithmeticExpression ) )
            {
            // InternalFLY.g:562:3: ()
            // InternalFLY.g:563:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPrintExpressionAccess().getPrintExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,19,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPrintExpressionAccess().getPrintlnKeyword_1());
              		
            }
            // InternalFLY.g:573:3: ( (lv_print_2_0= ruleArithmeticExpression ) )
            // InternalFLY.g:574:4: (lv_print_2_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:574:4: (lv_print_2_0= ruleArithmeticExpression )
            // InternalFLY.g:575:5: lv_print_2_0= ruleArithmeticExpression
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
    // InternalFLY.g:596:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalFLY.g:596:53: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalFLY.g:597:2: iv_ruleIfExpression= ruleIfExpression EOF
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
    // InternalFLY.g:603:1: ruleIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )? ) ;
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
            // InternalFLY.g:609:2: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )? ) )
            // InternalFLY.g:610:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )? )
            {
            // InternalFLY.g:610:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )? )
            // InternalFLY.g:611:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )?
            {
            // InternalFLY.g:611:3: ()
            // InternalFLY.g:612:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIfExpressionAccess().getIfExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfExpressionAccess().getIfKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,21,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalFLY.g:626:3: ( (lv_cond_3_0= ruleArithmeticExpression ) )
            // InternalFLY.g:627:4: (lv_cond_3_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:627:4: (lv_cond_3_0= ruleArithmeticExpression )
            // InternalFLY.g:628:5: lv_cond_3_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfExpressionAccess().getCondArithmeticExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_10);
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

            otherlv_4=(Token)match(input,22,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalFLY.g:649:3: ( (lv_then_5_0= ruleExpression ) )
            // InternalFLY.g:650:4: (lv_then_5_0= ruleExpression )
            {
            // InternalFLY.g:650:4: (lv_then_5_0= ruleExpression )
            // InternalFLY.g:651:5: lv_then_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_12);
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

            // InternalFLY.g:668:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) ) )?
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
                    // InternalFLY.g:669:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleExpression ) )
                    {
                    // InternalFLY.g:669:4: ( ( 'else' )=>otherlv_6= 'else' )
                    // InternalFLY.g:670:5: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getIfExpressionAccess().getElseKeyword_6_0());
                      				
                    }

                    }

                    // InternalFLY.g:676:4: ( (lv_else_7_0= ruleExpression ) )
                    // InternalFLY.g:677:5: (lv_else_7_0= ruleExpression )
                    {
                    // InternalFLY.g:677:5: (lv_else_7_0= ruleExpression )
                    // InternalFLY.g:678:6: lv_else_7_0= ruleExpression
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
    // InternalFLY.g:700:1: entryRuleForExpression returns [EObject current=null] : iv_ruleForExpression= ruleForExpression EOF ;
    public final EObject entryRuleForExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForExpression = null;


        try {
            // InternalFLY.g:700:54: (iv_ruleForExpression= ruleForExpression EOF )
            // InternalFLY.g:701:2: iv_ruleForExpression= ruleForExpression EOF
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
    // InternalFLY.g:707:1: ruleForExpression returns [EObject current=null] : ( () otherlv_1= 'for' ( (lv_index_2_0= ruleForIndex ) ) otherlv_3= 'in' ( (lv_object_4_0= ruleArithmeticExpression ) ) (otherlv_5= 'by' ( (lv_delimeter_6_0= ruleForDelimeter ) ) )? ( (lv_body_7_0= ruleExpression ) ) ) ;
    public final EObject ruleForExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_index_2_0 = null;

        EObject lv_object_4_0 = null;

        EObject lv_delimeter_6_0 = null;

        EObject lv_body_7_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:713:2: ( ( () otherlv_1= 'for' ( (lv_index_2_0= ruleForIndex ) ) otherlv_3= 'in' ( (lv_object_4_0= ruleArithmeticExpression ) ) (otherlv_5= 'by' ( (lv_delimeter_6_0= ruleForDelimeter ) ) )? ( (lv_body_7_0= ruleExpression ) ) ) )
            // InternalFLY.g:714:2: ( () otherlv_1= 'for' ( (lv_index_2_0= ruleForIndex ) ) otherlv_3= 'in' ( (lv_object_4_0= ruleArithmeticExpression ) ) (otherlv_5= 'by' ( (lv_delimeter_6_0= ruleForDelimeter ) ) )? ( (lv_body_7_0= ruleExpression ) ) )
            {
            // InternalFLY.g:714:2: ( () otherlv_1= 'for' ( (lv_index_2_0= ruleForIndex ) ) otherlv_3= 'in' ( (lv_object_4_0= ruleArithmeticExpression ) ) (otherlv_5= 'by' ( (lv_delimeter_6_0= ruleForDelimeter ) ) )? ( (lv_body_7_0= ruleExpression ) ) )
            // InternalFLY.g:715:3: () otherlv_1= 'for' ( (lv_index_2_0= ruleForIndex ) ) otherlv_3= 'in' ( (lv_object_4_0= ruleArithmeticExpression ) ) (otherlv_5= 'by' ( (lv_delimeter_6_0= ruleForDelimeter ) ) )? ( (lv_body_7_0= ruleExpression ) )
            {
            // InternalFLY.g:715:3: ()
            // InternalFLY.g:716:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getForExpressionAccess().getForExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,24,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getForExpressionAccess().getForKeyword_1());
              		
            }
            // InternalFLY.g:726:3: ( (lv_index_2_0= ruleForIndex ) )
            // InternalFLY.g:727:4: (lv_index_2_0= ruleForIndex )
            {
            // InternalFLY.g:727:4: (lv_index_2_0= ruleForIndex )
            // InternalFLY.g:728:5: lv_index_2_0= ruleForIndex
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForExpressionAccess().getIndexForIndexParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_index_2_0=ruleForIndex();

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
              						"org.xtext.FLY.ForIndex");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getForExpressionAccess().getInKeyword_3());
              		
            }
            // InternalFLY.g:749:3: ( (lv_object_4_0= ruleArithmeticExpression ) )
            // InternalFLY.g:750:4: (lv_object_4_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:750:4: (lv_object_4_0= ruleArithmeticExpression )
            // InternalFLY.g:751:5: lv_object_4_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForExpressionAccess().getObjectArithmeticExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_15);
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

            // InternalFLY.g:768:3: (otherlv_5= 'by' ( (lv_delimeter_6_0= ruleForDelimeter ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==26) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalFLY.g:769:4: otherlv_5= 'by' ( (lv_delimeter_6_0= ruleForDelimeter ) )
                    {
                    otherlv_5=(Token)match(input,26,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getForExpressionAccess().getByKeyword_5_0());
                      			
                    }
                    // InternalFLY.g:773:4: ( (lv_delimeter_6_0= ruleForDelimeter ) )
                    // InternalFLY.g:774:5: (lv_delimeter_6_0= ruleForDelimeter )
                    {
                    // InternalFLY.g:774:5: (lv_delimeter_6_0= ruleForDelimeter )
                    // InternalFLY.g:775:6: lv_delimeter_6_0= ruleForDelimeter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getForExpressionAccess().getDelimeterForDelimeterParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_delimeter_6_0=ruleForDelimeter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getForExpressionRule());
                      						}
                      						set(
                      							current,
                      							"delimeter",
                      							lv_delimeter_6_0,
                      							"org.xtext.FLY.ForDelimeter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalFLY.g:793:3: ( (lv_body_7_0= ruleExpression ) )
            // InternalFLY.g:794:4: (lv_body_7_0= ruleExpression )
            {
            // InternalFLY.g:794:4: (lv_body_7_0= ruleExpression )
            // InternalFLY.g:795:5: lv_body_7_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForExpressionAccess().getBodyExpressionParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_7_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForExpressionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_7_0,
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


    // $ANTLR start "entryRuleForDelimeter"
    // InternalFLY.g:816:1: entryRuleForDelimeter returns [EObject current=null] : iv_ruleForDelimeter= ruleForDelimeter EOF ;
    public final EObject entryRuleForDelimeter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForDelimeter = null;


        try {
            // InternalFLY.g:816:53: (iv_ruleForDelimeter= ruleForDelimeter EOF )
            // InternalFLY.g:817:2: iv_ruleForDelimeter= ruleForDelimeter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForDelimeterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleForDelimeter=ruleForDelimeter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForDelimeter; 
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
    // $ANTLR end "entryRuleForDelimeter"


    // $ANTLR start "ruleForDelimeter"
    // InternalFLY.g:823:1: ruleForDelimeter returns [EObject current=null] : ( ( (lv_type_0_0= 'row' ) ) | ( (lv_type_1_0= 'col' ) ) | ( ( (lv_type_2_0= 'delimeter' ) ) ( (lv_del_3_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleForDelimeter() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        Token lv_type_2_0=null;
        Token lv_del_3_0=null;


        	enterRule();

        try {
            // InternalFLY.g:829:2: ( ( ( (lv_type_0_0= 'row' ) ) | ( (lv_type_1_0= 'col' ) ) | ( ( (lv_type_2_0= 'delimeter' ) ) ( (lv_del_3_0= RULE_STRING ) ) ) ) )
            // InternalFLY.g:830:2: ( ( (lv_type_0_0= 'row' ) ) | ( (lv_type_1_0= 'col' ) ) | ( ( (lv_type_2_0= 'delimeter' ) ) ( (lv_del_3_0= RULE_STRING ) ) ) )
            {
            // InternalFLY.g:830:2: ( ( (lv_type_0_0= 'row' ) ) | ( (lv_type_1_0= 'col' ) ) | ( ( (lv_type_2_0= 'delimeter' ) ) ( (lv_del_3_0= RULE_STRING ) ) ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt8=1;
                }
                break;
            case 28:
                {
                alt8=2;
                }
                break;
            case 29:
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
                    // InternalFLY.g:831:3: ( (lv_type_0_0= 'row' ) )
                    {
                    // InternalFLY.g:831:3: ( (lv_type_0_0= 'row' ) )
                    // InternalFLY.g:832:4: (lv_type_0_0= 'row' )
                    {
                    // InternalFLY.g:832:4: (lv_type_0_0= 'row' )
                    // InternalFLY.g:833:5: lv_type_0_0= 'row'
                    {
                    lv_type_0_0=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_type_0_0, grammarAccess.getForDelimeterAccess().getTypeRowKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getForDelimeterRule());
                      					}
                      					setWithLastConsumed(current, "type", lv_type_0_0, "row");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:846:3: ( (lv_type_1_0= 'col' ) )
                    {
                    // InternalFLY.g:846:3: ( (lv_type_1_0= 'col' ) )
                    // InternalFLY.g:847:4: (lv_type_1_0= 'col' )
                    {
                    // InternalFLY.g:847:4: (lv_type_1_0= 'col' )
                    // InternalFLY.g:848:5: lv_type_1_0= 'col'
                    {
                    lv_type_1_0=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_type_1_0, grammarAccess.getForDelimeterAccess().getTypeColKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getForDelimeterRule());
                      					}
                      					setWithLastConsumed(current, "type", lv_type_1_0, "col");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFLY.g:861:3: ( ( (lv_type_2_0= 'delimeter' ) ) ( (lv_del_3_0= RULE_STRING ) ) )
                    {
                    // InternalFLY.g:861:3: ( ( (lv_type_2_0= 'delimeter' ) ) ( (lv_del_3_0= RULE_STRING ) ) )
                    // InternalFLY.g:862:4: ( (lv_type_2_0= 'delimeter' ) ) ( (lv_del_3_0= RULE_STRING ) )
                    {
                    // InternalFLY.g:862:4: ( (lv_type_2_0= 'delimeter' ) )
                    // InternalFLY.g:863:5: (lv_type_2_0= 'delimeter' )
                    {
                    // InternalFLY.g:863:5: (lv_type_2_0= 'delimeter' )
                    // InternalFLY.g:864:6: lv_type_2_0= 'delimeter'
                    {
                    lv_type_2_0=(Token)match(input,29,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_2_0, grammarAccess.getForDelimeterAccess().getTypeDelimeterKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getForDelimeterRule());
                      						}
                      						setWithLastConsumed(current, "type", lv_type_2_0, "delimeter");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:876:4: ( (lv_del_3_0= RULE_STRING ) )
                    // InternalFLY.g:877:5: (lv_del_3_0= RULE_STRING )
                    {
                    // InternalFLY.g:877:5: (lv_del_3_0= RULE_STRING )
                    // InternalFLY.g:878:6: lv_del_3_0= RULE_STRING
                    {
                    lv_del_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_del_3_0, grammarAccess.getForDelimeterAccess().getDelSTRINGTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getForDelimeterRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"del",
                      							lv_del_3_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
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
    // $ANTLR end "ruleForDelimeter"


    // $ANTLR start "entryRuleForIndex"
    // InternalFLY.g:899:1: entryRuleForIndex returns [EObject current=null] : iv_ruleForIndex= ruleForIndex EOF ;
    public final EObject entryRuleForIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForIndex = null;


        try {
            // InternalFLY.g:899:49: (iv_ruleForIndex= ruleForIndex EOF )
            // InternalFLY.g:900:2: iv_ruleForIndex= ruleForIndex EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForIndexRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleForIndex=ruleForIndex();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForIndex; 
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
    // $ANTLR end "entryRuleForIndex"


    // $ANTLR start "ruleForIndex"
    // InternalFLY.g:906:1: ruleForIndex returns [EObject current=null] : ( ( (lv_indices_0_0= ruleVariableFor ) ) (otherlv_1= ',' ( (lv_indices_2_0= ruleVariableFor ) ) )* ) ;
    public final EObject ruleForIndex() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_indices_0_0 = null;

        EObject lv_indices_2_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:912:2: ( ( ( (lv_indices_0_0= ruleVariableFor ) ) (otherlv_1= ',' ( (lv_indices_2_0= ruleVariableFor ) ) )* ) )
            // InternalFLY.g:913:2: ( ( (lv_indices_0_0= ruleVariableFor ) ) (otherlv_1= ',' ( (lv_indices_2_0= ruleVariableFor ) ) )* )
            {
            // InternalFLY.g:913:2: ( ( (lv_indices_0_0= ruleVariableFor ) ) (otherlv_1= ',' ( (lv_indices_2_0= ruleVariableFor ) ) )* )
            // InternalFLY.g:914:3: ( (lv_indices_0_0= ruleVariableFor ) ) (otherlv_1= ',' ( (lv_indices_2_0= ruleVariableFor ) ) )*
            {
            // InternalFLY.g:914:3: ( (lv_indices_0_0= ruleVariableFor ) )
            // InternalFLY.g:915:4: (lv_indices_0_0= ruleVariableFor )
            {
            // InternalFLY.g:915:4: (lv_indices_0_0= ruleVariableFor )
            // InternalFLY.g:916:5: lv_indices_0_0= ruleVariableFor
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForIndexAccess().getIndicesVariableForParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_indices_0_0=ruleVariableFor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForIndexRule());
              					}
              					add(
              						current,
              						"indices",
              						lv_indices_0_0,
              						"org.xtext.FLY.VariableFor");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalFLY.g:933:3: (otherlv_1= ',' ( (lv_indices_2_0= ruleVariableFor ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==30) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFLY.g:934:4: otherlv_1= ',' ( (lv_indices_2_0= ruleVariableFor ) )
            	    {
            	    otherlv_1=(Token)match(input,30,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getForIndexAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalFLY.g:938:4: ( (lv_indices_2_0= ruleVariableFor ) )
            	    // InternalFLY.g:939:5: (lv_indices_2_0= ruleVariableFor )
            	    {
            	    // InternalFLY.g:939:5: (lv_indices_2_0= ruleVariableFor )
            	    // InternalFLY.g:940:6: lv_indices_2_0= ruleVariableFor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getForIndexAccess().getIndicesVariableForParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
            	    lv_indices_2_0=ruleVariableFor();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getForIndexRule());
            	      						}
            	      						add(
            	      							current,
            	      							"indices",
            	      							lv_indices_2_0,
            	      							"org.xtext.FLY.VariableFor");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "ruleForIndex"


    // $ANTLR start "entryRuleVariableFor"
    // InternalFLY.g:962:1: entryRuleVariableFor returns [EObject current=null] : iv_ruleVariableFor= ruleVariableFor EOF ;
    public final EObject entryRuleVariableFor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableFor = null;


        try {
            // InternalFLY.g:962:52: (iv_ruleVariableFor= ruleVariableFor EOF )
            // InternalFLY.g:963:2: iv_ruleVariableFor= ruleVariableFor EOF
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
    // InternalFLY.g:969:1: ruleVariableFor returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariableFor() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFLY.g:975:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFLY.g:976:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFLY.g:976:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFLY.g:977:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalFLY.g:977:3: ()
            // InternalFLY.g:978:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableForAccess().getVariableDeclarationAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:984:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFLY.g:985:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFLY.g:985:4: (lv_name_1_0= RULE_ID )
            // InternalFLY.g:986:5: lv_name_1_0= RULE_ID
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
    // InternalFLY.g:1006:1: entryRuleWhileExpression returns [EObject current=null] : iv_ruleWhileExpression= ruleWhileExpression EOF ;
    public final EObject entryRuleWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileExpression = null;


        try {
            // InternalFLY.g:1006:56: (iv_ruleWhileExpression= ruleWhileExpression EOF )
            // InternalFLY.g:1007:2: iv_ruleWhileExpression= ruleWhileExpression EOF
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
    // InternalFLY.g:1013:1: ruleWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleExpression ) ) ) ;
    public final EObject ruleWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_cond_3_0 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:1019:2: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleExpression ) ) ) )
            // InternalFLY.g:1020:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleExpression ) ) )
            {
            // InternalFLY.g:1020:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleExpression ) ) )
            // InternalFLY.g:1021:3: () otherlv_1= 'while' otherlv_2= '(' ( (lv_cond_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleExpression ) )
            {
            // InternalFLY.g:1021:3: ()
            // InternalFLY.g:1022:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getWhileExpressionAccess().getWhileExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getWhileExpressionAccess().getWhileKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,21,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getWhileExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalFLY.g:1036:3: ( (lv_cond_3_0= ruleArithmeticExpression ) )
            // InternalFLY.g:1037:4: (lv_cond_3_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:1037:4: (lv_cond_3_0= ruleArithmeticExpression )
            // InternalFLY.g:1038:5: lv_cond_3_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWhileExpressionAccess().getCondArithmeticExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_10);
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

            otherlv_4=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getWhileExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalFLY.g:1059:3: ( (lv_body_5_0= ruleExpression ) )
            // InternalFLY.g:1060:4: (lv_body_5_0= ruleExpression )
            {
            // InternalFLY.g:1060:4: (lv_body_5_0= ruleExpression )
            // InternalFLY.g:1061:5: lv_body_5_0= ruleExpression
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
    // InternalFLY.g:1082:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockExpression = null;


        try {
            // InternalFLY.g:1082:56: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // InternalFLY.g:1083:2: iv_ruleBlockExpression= ruleBlockExpression EOF
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
    // InternalFLY.g:1089:1: ruleBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:1095:2: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )* otherlv_3= '}' ) )
            // InternalFLY.g:1096:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )* otherlv_3= '}' )
            {
            // InternalFLY.g:1096:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )* otherlv_3= '}' )
            // InternalFLY.g:1097:3: () otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )* otherlv_3= '}'
            {
            // InternalFLY.g:1097:3: ()
            // InternalFLY.g:1098:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockExpressionAccess().getBlockExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,32,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalFLY.g:1108:3: ( (lv_expressions_2_0= ruleExpression ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||LA10_0==13||(LA10_0>=19 && LA10_0<=20)||LA10_0==24||(LA10_0>=31 && LA10_0<=32)||(LA10_0>=34 && LA10_0<=41)||(LA10_0>=47 && LA10_0<=48)||(LA10_0>=51 && LA10_0<=52)||(LA10_0>=55 && LA10_0<=56)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalFLY.g:1109:4: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalFLY.g:1109:4: (lv_expressions_2_0= ruleExpression )
            	    // InternalFLY.g:1110:5: lv_expressions_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBlockExpressionAccess().getExpressionsExpressionParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_19);
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
            	    break loop10;
                }
            } while (true);

            otherlv_3=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
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
    // InternalFLY.g:1135:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalFLY.g:1135:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalFLY.g:1136:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
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
    // InternalFLY.g:1142:1: ruleVariableDeclaration returns [EObject current=null] : ( ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) ) | ( () ( (lv_typeobject_8_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( (lv_right_11_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_13_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleDeclarationObject ) ) ) ( ( ( 'on' ) ) ( ( RULE_ID ) ) )? ) )=> ( ( (lv_name_14_0= RULE_ID ) ) otherlv_15= '=' ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) ) ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )? ) ) ) | ( () ( (lv_typeobject_21_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_22_0= RULE_ID ) ) ) ) | ( () ( (lv_typeobject_24_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_25_0= RULE_ID ) ) otherlv_26= '=' ( (lv_right_27_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_29_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_30_0= RULE_ID ) ) otherlv_31= '=' ( (lv_right_32_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_34_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_35_0= RULE_ID ) ) otherlv_36= 'on' ( (otherlv_37= RULE_ID ) ) ) ) ) | ( () ( (lv_typeobject_39_0= 'const' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_40_0= RULE_ID ) ) otherlv_41= '=' ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) ) ) ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_typeobject_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_typeobject_8_0=null;
        Token lv_name_9_0=null;
        Token otherlv_10=null;
        Token lv_typeobject_13_0=null;
        Token lv_name_14_0=null;
        Token otherlv_15=null;
        Token lv_onCloud_18_0=null;
        Token otherlv_19=null;
        Token lv_typeobject_21_0=null;
        Token lv_name_22_0=null;
        Token lv_typeobject_24_0=null;
        Token lv_name_25_0=null;
        Token otherlv_26=null;
        Token lv_typeobject_29_0=null;
        Token lv_name_30_0=null;
        Token otherlv_31=null;
        Token lv_typeobject_34_0=null;
        Token lv_name_35_0=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        Token lv_typeobject_39_0=null;
        Token lv_name_40_0=null;
        Token otherlv_41=null;
        EObject lv_right_4_0 = null;

        EObject lv_right_5_0 = null;

        EObject lv_right_6_0 = null;

        EObject lv_right_11_0 = null;

        EObject lv_right_16_0 = null;

        EObject lv_right_17_0 = null;

        EObject lv_right_27_0 = null;

        EObject lv_right_32_0 = null;

        EObject lv_right_42_0 = null;

        EObject lv_right_43_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:1148:2: ( ( ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) ) | ( () ( (lv_typeobject_8_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( (lv_right_11_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_13_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleDeclarationObject ) ) ) ( ( ( 'on' ) ) ( ( RULE_ID ) ) )? ) )=> ( ( (lv_name_14_0= RULE_ID ) ) otherlv_15= '=' ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) ) ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )? ) ) ) | ( () ( (lv_typeobject_21_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_22_0= RULE_ID ) ) ) ) | ( () ( (lv_typeobject_24_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_25_0= RULE_ID ) ) otherlv_26= '=' ( (lv_right_27_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_29_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_30_0= RULE_ID ) ) otherlv_31= '=' ( (lv_right_32_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_34_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_35_0= RULE_ID ) ) otherlv_36= 'on' ( (otherlv_37= RULE_ID ) ) ) ) ) | ( () ( (lv_typeobject_39_0= 'const' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_40_0= RULE_ID ) ) otherlv_41= '=' ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) ) ) ) ) ) )
            // InternalFLY.g:1149:2: ( ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) ) | ( () ( (lv_typeobject_8_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( (lv_right_11_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_13_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleDeclarationObject ) ) ) ( ( ( 'on' ) ) ( ( RULE_ID ) ) )? ) )=> ( ( (lv_name_14_0= RULE_ID ) ) otherlv_15= '=' ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) ) ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )? ) ) ) | ( () ( (lv_typeobject_21_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_22_0= RULE_ID ) ) ) ) | ( () ( (lv_typeobject_24_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_25_0= RULE_ID ) ) otherlv_26= '=' ( (lv_right_27_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_29_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_30_0= RULE_ID ) ) otherlv_31= '=' ( (lv_right_32_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_34_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_35_0= RULE_ID ) ) otherlv_36= 'on' ( (otherlv_37= RULE_ID ) ) ) ) ) | ( () ( (lv_typeobject_39_0= 'const' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_40_0= RULE_ID ) ) otherlv_41= '=' ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) ) ) ) ) )
            {
            // InternalFLY.g:1149:2: ( ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) ) | ( () ( (lv_typeobject_8_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( (lv_right_11_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_13_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleDeclarationObject ) ) ) ( ( ( 'on' ) ) ( ( RULE_ID ) ) )? ) )=> ( ( (lv_name_14_0= RULE_ID ) ) otherlv_15= '=' ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) ) ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )? ) ) ) | ( () ( (lv_typeobject_21_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_22_0= RULE_ID ) ) ) ) | ( () ( (lv_typeobject_24_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_25_0= RULE_ID ) ) otherlv_26= '=' ( (lv_right_27_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_29_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_30_0= RULE_ID ) ) otherlv_31= '=' ( (lv_right_32_0= ruleDeclarationObject ) ) ) ) ) | ( () ( (lv_typeobject_34_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_35_0= RULE_ID ) ) otherlv_36= 'on' ( (otherlv_37= RULE_ID ) ) ) ) ) | ( () ( (lv_typeobject_39_0= 'const' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_40_0= RULE_ID ) ) otherlv_41= '=' ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) ) ) ) ) )
            int alt15=8;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt15=1;
                }
                break;
            case 35:
                {
                alt15=2;
                }
                break;
            case 36:
                {
                alt15=3;
                }
                break;
            case 37:
                {
                alt15=4;
                }
                break;
            case 38:
                {
                alt15=5;
                }
                break;
            case 39:
                {
                alt15=6;
                }
                break;
            case 40:
                {
                alt15=7;
                }
                break;
            case 41:
                {
                alt15=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalFLY.g:1150:3: ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) )
                    {
                    // InternalFLY.g:1150:3: ( () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) ) )
                    // InternalFLY.g:1151:4: () ( (lv_typeobject_1_0= 'var' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) )
                    {
                    // InternalFLY.g:1151:4: ()
                    // InternalFLY.g:1152:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1158:4: ( (lv_typeobject_1_0= 'var' ) )
                    // InternalFLY.g:1159:5: (lv_typeobject_1_0= 'var' )
                    {
                    // InternalFLY.g:1159:5: (lv_typeobject_1_0= 'var' )
                    // InternalFLY.g:1160:6: lv_typeobject_1_0= 'var'
                    {
                    lv_typeobject_1_0=(Token)match(input,34,FOLLOW_5); if (state.failed) return current;
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

                    // InternalFLY.g:1172:4: ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) ) )
                    // InternalFLY.g:1173:5: ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) | ( ( ruleFlyFunctionCall ) ) ) ) )=> ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) )
                    {
                    // InternalFLY.g:1201:5: ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) ) )
                    // InternalFLY.g:1202:6: ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) )
                    {
                    // InternalFLY.g:1202:6: ( (lv_name_2_0= RULE_ID ) )
                    // InternalFLY.g:1203:7: (lv_name_2_0= RULE_ID )
                    {
                    // InternalFLY.g:1203:7: (lv_name_2_0= RULE_ID )
                    // InternalFLY.g:1204:8: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
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

                    otherlv_3=(Token)match(input,17,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_0_2_0_1());
                      					
                    }
                    // InternalFLY.g:1224:6: ( ( (lv_right_4_0= ruleArithmeticExpression ) ) | ( (lv_right_5_0= ruleObject ) ) | ( (lv_right_6_0= ruleFlyFunctionCall ) ) )
                    int alt11=3;
                    switch ( input.LA(1) ) {
                    case RULE_ID:
                    case RULE_STRING:
                    case RULE_INT:
                    case RULE_FLOAT:
                    case 21:
                    case 46:
                    case 67:
                    case 68:
                    case 71:
                    case 80:
                    case 81:
                    case 82:
                        {
                        alt11=1;
                        }
                        break;
                    case 42:
                        {
                        switch ( input.LA(2) ) {
                        case RULE_INT:
                            {
                            int LA11_5 = input.LA(3);

                            if ( (LA11_5==30||LA11_5==43||(LA11_5>=59 && LA11_5<=70)||(LA11_5>=72 && LA11_5<=73)) ) {
                                alt11=2;
                            }
                            else if ( (LA11_5==45) ) {
                                alt11=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 11, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RULE_ID:
                            {
                            int LA11_6 = input.LA(3);

                            if ( (LA11_6==21||LA11_6==30||(LA11_6>=42 && LA11_6<=44)||(LA11_6>=49 && LA11_6<=50)||(LA11_6>=59 && LA11_6<=70)||(LA11_6>=72 && LA11_6<=73)) ) {
                                alt11=2;
                            }
                            else if ( (LA11_6==45) ) {
                                alt11=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 11, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RULE_STRING:
                        case RULE_FLOAT:
                        case 21:
                        case 30:
                        case 42:
                        case 43:
                        case 46:
                        case 67:
                        case 68:
                        case 71:
                        case 80:
                        case 81:
                        case 82:
                            {
                            alt11=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 2, input);

                            throw nvae;
                        }

                        }
                        break;
                    case 32:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                        {
                        alt11=2;
                        }
                        break;
                    case 51:
                    case 52:
                        {
                        alt11=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }

                    switch (alt11) {
                        case 1 :
                            // InternalFLY.g:1225:7: ( (lv_right_4_0= ruleArithmeticExpression ) )
                            {
                            // InternalFLY.g:1225:7: ( (lv_right_4_0= ruleArithmeticExpression ) )
                            // InternalFLY.g:1226:8: (lv_right_4_0= ruleArithmeticExpression )
                            {
                            // InternalFLY.g:1226:8: (lv_right_4_0= ruleArithmeticExpression )
                            // InternalFLY.g:1227:9: lv_right_4_0= ruleArithmeticExpression
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
                            // InternalFLY.g:1245:7: ( (lv_right_5_0= ruleObject ) )
                            {
                            // InternalFLY.g:1245:7: ( (lv_right_5_0= ruleObject ) )
                            // InternalFLY.g:1246:8: (lv_right_5_0= ruleObject )
                            {
                            // InternalFLY.g:1246:8: (lv_right_5_0= ruleObject )
                            // InternalFLY.g:1247:9: lv_right_5_0= ruleObject
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
                            // InternalFLY.g:1265:7: ( (lv_right_6_0= ruleFlyFunctionCall ) )
                            {
                            // InternalFLY.g:1265:7: ( (lv_right_6_0= ruleFlyFunctionCall ) )
                            // InternalFLY.g:1266:8: (lv_right_6_0= ruleFlyFunctionCall )
                            {
                            // InternalFLY.g:1266:8: (lv_right_6_0= ruleFlyFunctionCall )
                            // InternalFLY.g:1267:9: lv_right_6_0= ruleFlyFunctionCall
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
                    // InternalFLY.g:1289:3: ( () ( (lv_typeobject_8_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( (lv_right_11_0= ruleDeclarationObject ) ) ) ) )
                    {
                    // InternalFLY.g:1289:3: ( () ( (lv_typeobject_8_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( (lv_right_11_0= ruleDeclarationObject ) ) ) ) )
                    // InternalFLY.g:1290:4: () ( (lv_typeobject_8_0= 'env' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( (lv_right_11_0= ruleDeclarationObject ) ) ) )
                    {
                    // InternalFLY.g:1290:4: ()
                    // InternalFLY.g:1291:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getEnvironmentDeclarationAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1297:4: ( (lv_typeobject_8_0= 'env' ) )
                    // InternalFLY.g:1298:5: (lv_typeobject_8_0= 'env' )
                    {
                    // InternalFLY.g:1298:5: (lv_typeobject_8_0= 'env' )
                    // InternalFLY.g:1299:6: lv_typeobject_8_0= 'env'
                    {
                    lv_typeobject_8_0=(Token)match(input,35,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_8_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectEnvKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_8_0, "env");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1311:4: ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( (lv_right_11_0= ruleDeclarationObject ) ) ) )
                    // InternalFLY.g:1312:5: ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( (lv_right_11_0= ruleDeclarationObject ) ) )
                    {
                    // InternalFLY.g:1326:5: ( ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( (lv_right_11_0= ruleDeclarationObject ) ) )
                    // InternalFLY.g:1327:6: ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( (lv_right_11_0= ruleDeclarationObject ) )
                    {
                    // InternalFLY.g:1327:6: ( (lv_name_9_0= RULE_ID ) )
                    // InternalFLY.g:1328:7: (lv_name_9_0= RULE_ID )
                    {
                    // InternalFLY.g:1328:7: (lv_name_9_0= RULE_ID )
                    // InternalFLY.g:1329:8: lv_name_9_0= RULE_ID
                    {
                    lv_name_9_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
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

                    otherlv_10=(Token)match(input,17,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_10, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_1_2_0_1());
                      					
                    }
                    // InternalFLY.g:1349:6: ( (lv_right_11_0= ruleDeclarationObject ) )
                    // InternalFLY.g:1350:7: (lv_right_11_0= ruleDeclarationObject )
                    {
                    // InternalFLY.g:1350:7: (lv_right_11_0= ruleDeclarationObject )
                    // InternalFLY.g:1351:8: lv_right_11_0= ruleDeclarationObject
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightDeclarationObjectParserRuleCall_1_2_0_2_0());
                      							
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_11_0=ruleDeclarationObject();

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
                case 3 :
                    // InternalFLY.g:1372:3: ( () ( (lv_typeobject_13_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleDeclarationObject ) ) ) ( ( ( 'on' ) ) ( ( RULE_ID ) ) )? ) )=> ( ( (lv_name_14_0= RULE_ID ) ) otherlv_15= '=' ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) ) ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )? ) ) )
                    {
                    // InternalFLY.g:1372:3: ( () ( (lv_typeobject_13_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleDeclarationObject ) ) ) ( ( ( 'on' ) ) ( ( RULE_ID ) ) )? ) )=> ( ( (lv_name_14_0= RULE_ID ) ) otherlv_15= '=' ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) ) ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )? ) ) )
                    // InternalFLY.g:1373:4: () ( (lv_typeobject_13_0= 'dat' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleDeclarationObject ) ) ) ( ( ( 'on' ) ) ( ( RULE_ID ) ) )? ) )=> ( ( (lv_name_14_0= RULE_ID ) ) otherlv_15= '=' ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) ) ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )? ) )
                    {
                    // InternalFLY.g:1373:4: ()
                    // InternalFLY.g:1374:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getDatDeclarationAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1380:4: ( (lv_typeobject_13_0= 'dat' ) )
                    // InternalFLY.g:1381:5: (lv_typeobject_13_0= 'dat' )
                    {
                    // InternalFLY.g:1381:5: (lv_typeobject_13_0= 'dat' )
                    // InternalFLY.g:1382:6: lv_typeobject_13_0= 'dat'
                    {
                    lv_typeobject_13_0=(Token)match(input,36,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_13_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectDatKeyword_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_13_0, "dat");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1394:4: ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleDeclarationObject ) ) ) ( ( ( 'on' ) ) ( ( RULE_ID ) ) )? ) )=> ( ( (lv_name_14_0= RULE_ID ) ) otherlv_15= '=' ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) ) ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )? ) )
                    // InternalFLY.g:1395:5: ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleDeclarationObject ) ) ) ( ( ( 'on' ) ) ( ( RULE_ID ) ) )? ) )=> ( ( (lv_name_14_0= RULE_ID ) ) otherlv_15= '=' ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) ) ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )? )
                    {
                    // InternalFLY.g:1429:5: ( ( (lv_name_14_0= RULE_ID ) ) otherlv_15= '=' ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) ) ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )? )
                    // InternalFLY.g:1430:6: ( (lv_name_14_0= RULE_ID ) ) otherlv_15= '=' ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) ) ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )?
                    {
                    // InternalFLY.g:1430:6: ( (lv_name_14_0= RULE_ID ) )
                    // InternalFLY.g:1431:7: (lv_name_14_0= RULE_ID )
                    {
                    // InternalFLY.g:1431:7: (lv_name_14_0= RULE_ID )
                    // InternalFLY.g:1432:8: lv_name_14_0= RULE_ID
                    {
                    lv_name_14_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_14_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_2_0_0_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_14_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }

                    otherlv_15=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_15, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_2_2_0_1());
                      					
                    }
                    // InternalFLY.g:1452:6: ( ( (lv_right_16_0= ruleArithmeticExpression ) ) | ( (lv_right_17_0= ruleDeclarationObject ) ) )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>=RULE_ID && LA12_0<=RULE_INT)||LA12_0==RULE_FLOAT||LA12_0==21||LA12_0==46||(LA12_0>=67 && LA12_0<=68)||LA12_0==71||(LA12_0>=80 && LA12_0<=82)) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==42) ) {
                        int LA12_2 = input.LA(2);

                        if ( (LA12_2==RULE_ID) ) {
                            int LA12_3 = input.LA(3);

                            if ( (LA12_3==17) ) {
                                alt12=2;
                            }
                            else if ( (LA12_3==45) ) {
                                alt12=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 12, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA12_2==RULE_INT) ) {
                            alt12=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 12, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalFLY.g:1453:7: ( (lv_right_16_0= ruleArithmeticExpression ) )
                            {
                            // InternalFLY.g:1453:7: ( (lv_right_16_0= ruleArithmeticExpression ) )
                            // InternalFLY.g:1454:8: (lv_right_16_0= ruleArithmeticExpression )
                            {
                            // InternalFLY.g:1454:8: (lv_right_16_0= ruleArithmeticExpression )
                            // InternalFLY.g:1455:9: lv_right_16_0= ruleArithmeticExpression
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightArithmeticExpressionParserRuleCall_2_2_0_2_0_0());
                              								
                            }
                            pushFollow(FOLLOW_23);
                            lv_right_16_0=ruleArithmeticExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                              									}
                              									set(
                              										current,
                              										"right",
                              										lv_right_16_0,
                              										"org.xtext.FLY.ArithmeticExpression");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalFLY.g:1473:7: ( (lv_right_17_0= ruleDeclarationObject ) )
                            {
                            // InternalFLY.g:1473:7: ( (lv_right_17_0= ruleDeclarationObject ) )
                            // InternalFLY.g:1474:8: (lv_right_17_0= ruleDeclarationObject )
                            {
                            // InternalFLY.g:1474:8: (lv_right_17_0= ruleDeclarationObject )
                            // InternalFLY.g:1475:9: lv_right_17_0= ruleDeclarationObject
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightDeclarationObjectParserRuleCall_2_2_0_2_1_0());
                              								
                            }
                            pushFollow(FOLLOW_23);
                            lv_right_17_0=ruleDeclarationObject();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                              									}
                              									set(
                              										current,
                              										"right",
                              										lv_right_17_0,
                              										"org.xtext.FLY.DeclarationObject");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalFLY.g:1493:6: ( ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==16) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalFLY.g:1494:7: ( (lv_onCloud_18_0= 'on' ) ) ( (otherlv_19= RULE_ID ) )
                            {
                            // InternalFLY.g:1494:7: ( (lv_onCloud_18_0= 'on' ) )
                            // InternalFLY.g:1495:8: (lv_onCloud_18_0= 'on' )
                            {
                            // InternalFLY.g:1495:8: (lv_onCloud_18_0= 'on' )
                            // InternalFLY.g:1496:9: lv_onCloud_18_0= 'on'
                            {
                            lv_onCloud_18_0=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									newLeafNode(lv_onCloud_18_0, grammarAccess.getVariableDeclarationAccess().getOnCloudOnKeyword_2_2_0_3_0_0());
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getVariableDeclarationRule());
                              									}
                              									setWithLastConsumed(current, "onCloud", true, "on");
                              								
                            }

                            }


                            }

                            // InternalFLY.g:1508:7: ( (otherlv_19= RULE_ID ) )
                            // InternalFLY.g:1509:8: (otherlv_19= RULE_ID )
                            {
                            // InternalFLY.g:1509:8: (otherlv_19= RULE_ID )
                            // InternalFLY.g:1510:9: otherlv_19= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getVariableDeclarationRule());
                              									}
                              								
                            }
                            otherlv_19=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									newLeafNode(otherlv_19, grammarAccess.getVariableDeclarationAccess().getEnvironmentEnvironmentDeclarationCrossReference_2_2_0_3_1_0());
                              								
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
                case 4 :
                    // InternalFLY.g:1526:3: ( () ( (lv_typeobject_21_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_22_0= RULE_ID ) ) ) )
                    {
                    // InternalFLY.g:1526:3: ( () ( (lv_typeobject_21_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_22_0= RULE_ID ) ) ) )
                    // InternalFLY.g:1527:4: () ( (lv_typeobject_21_0= 'random' ) ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_22_0= RULE_ID ) ) )
                    {
                    // InternalFLY.g:1527:4: ()
                    // InternalFLY.g:1528:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getRandomDeclarationAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1534:4: ( (lv_typeobject_21_0= 'random' ) )
                    // InternalFLY.g:1535:5: (lv_typeobject_21_0= 'random' )
                    {
                    // InternalFLY.g:1535:5: (lv_typeobject_21_0= 'random' )
                    // InternalFLY.g:1536:6: lv_typeobject_21_0= 'random'
                    {
                    lv_typeobject_21_0=(Token)match(input,37,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_21_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectRandomKeyword_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_21_0, "random");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1548:4: ( ( ( ( RULE_ID ) ) )=> ( (lv_name_22_0= RULE_ID ) ) )
                    // InternalFLY.g:1549:5: ( ( ( RULE_ID ) ) )=> ( (lv_name_22_0= RULE_ID ) )
                    {
                    // InternalFLY.g:1555:5: ( (lv_name_22_0= RULE_ID ) )
                    // InternalFLY.g:1556:6: (lv_name_22_0= RULE_ID )
                    {
                    // InternalFLY.g:1556:6: (lv_name_22_0= RULE_ID )
                    // InternalFLY.g:1557:7: lv_name_22_0= RULE_ID
                    {
                    lv_name_22_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_name_22_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_3_2_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"name",
                      								lv_name_22_0,
                      								"org.xtext.FLY.ID");
                      						
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalFLY.g:1576:3: ( () ( (lv_typeobject_24_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_25_0= RULE_ID ) ) otherlv_26= '=' ( (lv_right_27_0= ruleDeclarationObject ) ) ) ) )
                    {
                    // InternalFLY.g:1576:3: ( () ( (lv_typeobject_24_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_25_0= RULE_ID ) ) otherlv_26= '=' ( (lv_right_27_0= ruleDeclarationObject ) ) ) ) )
                    // InternalFLY.g:1577:4: () ( (lv_typeobject_24_0= 'bin' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_25_0= RULE_ID ) ) otherlv_26= '=' ( (lv_right_27_0= ruleDeclarationObject ) ) ) )
                    {
                    // InternalFLY.g:1577:4: ()
                    // InternalFLY.g:1578:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getBinDeclarationAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1584:4: ( (lv_typeobject_24_0= 'bin' ) )
                    // InternalFLY.g:1585:5: (lv_typeobject_24_0= 'bin' )
                    {
                    // InternalFLY.g:1585:5: (lv_typeobject_24_0= 'bin' )
                    // InternalFLY.g:1586:6: lv_typeobject_24_0= 'bin'
                    {
                    lv_typeobject_24_0=(Token)match(input,38,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_24_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectBinKeyword_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_24_0, "bin");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1598:4: ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_25_0= RULE_ID ) ) otherlv_26= '=' ( (lv_right_27_0= ruleDeclarationObject ) ) ) )
                    // InternalFLY.g:1599:5: ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_25_0= RULE_ID ) ) otherlv_26= '=' ( (lv_right_27_0= ruleDeclarationObject ) ) )
                    {
                    // InternalFLY.g:1613:5: ( ( (lv_name_25_0= RULE_ID ) ) otherlv_26= '=' ( (lv_right_27_0= ruleDeclarationObject ) ) )
                    // InternalFLY.g:1614:6: ( (lv_name_25_0= RULE_ID ) ) otherlv_26= '=' ( (lv_right_27_0= ruleDeclarationObject ) )
                    {
                    // InternalFLY.g:1614:6: ( (lv_name_25_0= RULE_ID ) )
                    // InternalFLY.g:1615:7: (lv_name_25_0= RULE_ID )
                    {
                    // InternalFLY.g:1615:7: (lv_name_25_0= RULE_ID )
                    // InternalFLY.g:1616:8: lv_name_25_0= RULE_ID
                    {
                    lv_name_25_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_25_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_4_2_0_0_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_25_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }

                    otherlv_26=(Token)match(input,17,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_26, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_4_2_0_1());
                      					
                    }
                    // InternalFLY.g:1636:6: ( (lv_right_27_0= ruleDeclarationObject ) )
                    // InternalFLY.g:1637:7: (lv_right_27_0= ruleDeclarationObject )
                    {
                    // InternalFLY.g:1637:7: (lv_right_27_0= ruleDeclarationObject )
                    // InternalFLY.g:1638:8: lv_right_27_0= ruleDeclarationObject
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightDeclarationObjectParserRuleCall_4_2_0_2_0());
                      							
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_27_0=ruleDeclarationObject();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      								}
                      								set(
                      									current,
                      									"right",
                      									lv_right_27_0,
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
                    // InternalFLY.g:1659:3: ( () ( (lv_typeobject_29_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_30_0= RULE_ID ) ) otherlv_31= '=' ( (lv_right_32_0= ruleDeclarationObject ) ) ) ) )
                    {
                    // InternalFLY.g:1659:3: ( () ( (lv_typeobject_29_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_30_0= RULE_ID ) ) otherlv_31= '=' ( (lv_right_32_0= ruleDeclarationObject ) ) ) ) )
                    // InternalFLY.g:1660:4: () ( (lv_typeobject_29_0= 'opt' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_30_0= RULE_ID ) ) otherlv_31= '=' ( (lv_right_32_0= ruleDeclarationObject ) ) ) )
                    {
                    // InternalFLY.g:1660:4: ()
                    // InternalFLY.g:1661:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getOptimizerDeclarationAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1667:4: ( (lv_typeobject_29_0= 'opt' ) )
                    // InternalFLY.g:1668:5: (lv_typeobject_29_0= 'opt' )
                    {
                    // InternalFLY.g:1668:5: (lv_typeobject_29_0= 'opt' )
                    // InternalFLY.g:1669:6: lv_typeobject_29_0= 'opt'
                    {
                    lv_typeobject_29_0=(Token)match(input,39,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_29_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectOptKeyword_5_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_29_0, "opt");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1681:4: ( ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_30_0= RULE_ID ) ) otherlv_31= '=' ( (lv_right_32_0= ruleDeclarationObject ) ) ) )
                    // InternalFLY.g:1682:5: ( ( ( ( RULE_ID ) ) '=' ( ( ruleDeclarationObject ) ) ) )=> ( ( (lv_name_30_0= RULE_ID ) ) otherlv_31= '=' ( (lv_right_32_0= ruleDeclarationObject ) ) )
                    {
                    // InternalFLY.g:1696:5: ( ( (lv_name_30_0= RULE_ID ) ) otherlv_31= '=' ( (lv_right_32_0= ruleDeclarationObject ) ) )
                    // InternalFLY.g:1697:6: ( (lv_name_30_0= RULE_ID ) ) otherlv_31= '=' ( (lv_right_32_0= ruleDeclarationObject ) )
                    {
                    // InternalFLY.g:1697:6: ( (lv_name_30_0= RULE_ID ) )
                    // InternalFLY.g:1698:7: (lv_name_30_0= RULE_ID )
                    {
                    // InternalFLY.g:1698:7: (lv_name_30_0= RULE_ID )
                    // InternalFLY.g:1699:8: lv_name_30_0= RULE_ID
                    {
                    lv_name_30_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_30_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_5_2_0_0_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_30_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }

                    otherlv_31=(Token)match(input,17,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_31, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_5_2_0_1());
                      					
                    }
                    // InternalFLY.g:1719:6: ( (lv_right_32_0= ruleDeclarationObject ) )
                    // InternalFLY.g:1720:7: (lv_right_32_0= ruleDeclarationObject )
                    {
                    // InternalFLY.g:1720:7: (lv_right_32_0= ruleDeclarationObject )
                    // InternalFLY.g:1721:8: lv_right_32_0= ruleDeclarationObject
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightDeclarationObjectParserRuleCall_5_2_0_2_0());
                      							
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_32_0=ruleDeclarationObject();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      								}
                      								set(
                      									current,
                      									"right",
                      									lv_right_32_0,
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
                    // InternalFLY.g:1742:3: ( () ( (lv_typeobject_34_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_35_0= RULE_ID ) ) otherlv_36= 'on' ( (otherlv_37= RULE_ID ) ) ) ) )
                    {
                    // InternalFLY.g:1742:3: ( () ( (lv_typeobject_34_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_35_0= RULE_ID ) ) otherlv_36= 'on' ( (otherlv_37= RULE_ID ) ) ) ) )
                    // InternalFLY.g:1743:4: () ( (lv_typeobject_34_0= 'channel' ) ) ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_35_0= RULE_ID ) ) otherlv_36= 'on' ( (otherlv_37= RULE_ID ) ) ) )
                    {
                    // InternalFLY.g:1743:4: ()
                    // InternalFLY.g:1744:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getChannelDeclarationAction_6_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1750:4: ( (lv_typeobject_34_0= 'channel' ) )
                    // InternalFLY.g:1751:5: (lv_typeobject_34_0= 'channel' )
                    {
                    // InternalFLY.g:1751:5: (lv_typeobject_34_0= 'channel' )
                    // InternalFLY.g:1752:6: lv_typeobject_34_0= 'channel'
                    {
                    lv_typeobject_34_0=(Token)match(input,40,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_34_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectChannelKeyword_6_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_34_0, "channel");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1764:4: ( ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_35_0= RULE_ID ) ) otherlv_36= 'on' ( (otherlv_37= RULE_ID ) ) ) )
                    // InternalFLY.g:1765:5: ( ( ( ( RULE_ID ) ) 'on' ( ( RULE_ID ) ) ) )=> ( ( (lv_name_35_0= RULE_ID ) ) otherlv_36= 'on' ( (otherlv_37= RULE_ID ) ) )
                    {
                    // InternalFLY.g:1779:5: ( ( (lv_name_35_0= RULE_ID ) ) otherlv_36= 'on' ( (otherlv_37= RULE_ID ) ) )
                    // InternalFLY.g:1780:6: ( (lv_name_35_0= RULE_ID ) ) otherlv_36= 'on' ( (otherlv_37= RULE_ID ) )
                    {
                    // InternalFLY.g:1780:6: ( (lv_name_35_0= RULE_ID ) )
                    // InternalFLY.g:1781:7: (lv_name_35_0= RULE_ID )
                    {
                    // InternalFLY.g:1781:7: (lv_name_35_0= RULE_ID )
                    // InternalFLY.g:1782:8: lv_name_35_0= RULE_ID
                    {
                    lv_name_35_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_35_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_6_2_0_0_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_35_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }

                    otherlv_36=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_36, grammarAccess.getVariableDeclarationAccess().getOnKeyword_6_2_0_1());
                      					
                    }
                    // InternalFLY.g:1802:6: ( (otherlv_37= RULE_ID ) )
                    // InternalFLY.g:1803:7: (otherlv_37= RULE_ID )
                    {
                    // InternalFLY.g:1803:7: (otherlv_37= RULE_ID )
                    // InternalFLY.g:1804:8: otherlv_37= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      							
                    }
                    otherlv_37=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(otherlv_37, grammarAccess.getVariableDeclarationAccess().getEnvironmentEnvironmentDeclarationCrossReference_6_2_0_2_0());
                      							
                    }

                    }


                    }


                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalFLY.g:1819:3: ( () ( (lv_typeobject_39_0= 'const' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_40_0= RULE_ID ) ) otherlv_41= '=' ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) ) ) ) )
                    {
                    // InternalFLY.g:1819:3: ( () ( (lv_typeobject_39_0= 'const' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_40_0= RULE_ID ) ) otherlv_41= '=' ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) ) ) ) )
                    // InternalFLY.g:1820:4: () ( (lv_typeobject_39_0= 'const' ) ) ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_40_0= RULE_ID ) ) otherlv_41= '=' ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) ) ) )
                    {
                    // InternalFLY.g:1820:4: ()
                    // InternalFLY.g:1821:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getVariableDeclarationAccess().getConstantDeclarationAction_7_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:1827:4: ( (lv_typeobject_39_0= 'const' ) )
                    // InternalFLY.g:1828:5: (lv_typeobject_39_0= 'const' )
                    {
                    // InternalFLY.g:1828:5: (lv_typeobject_39_0= 'const' )
                    // InternalFLY.g:1829:6: lv_typeobject_39_0= 'const'
                    {
                    lv_typeobject_39_0=(Token)match(input,41,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_typeobject_39_0, grammarAccess.getVariableDeclarationAccess().getTypeobjectConstKeyword_7_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "typeobject", lv_typeobject_39_0, "const");
                      					
                    }

                    }


                    }

                    // InternalFLY.g:1841:4: ( ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_40_0= RULE_ID ) ) otherlv_41= '=' ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) ) ) )
                    // InternalFLY.g:1842:5: ( ( ( ( RULE_ID ) ) '=' ( ( ( ruleArithmeticExpression ) ) | ( ( ruleObject ) ) ) ) )=> ( ( (lv_name_40_0= RULE_ID ) ) otherlv_41= '=' ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) ) )
                    {
                    // InternalFLY.g:1864:5: ( ( (lv_name_40_0= RULE_ID ) ) otherlv_41= '=' ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) ) )
                    // InternalFLY.g:1865:6: ( (lv_name_40_0= RULE_ID ) ) otherlv_41= '=' ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) )
                    {
                    // InternalFLY.g:1865:6: ( (lv_name_40_0= RULE_ID ) )
                    // InternalFLY.g:1866:7: (lv_name_40_0= RULE_ID )
                    {
                    // InternalFLY.g:1866:7: (lv_name_40_0= RULE_ID )
                    // InternalFLY.g:1867:8: lv_name_40_0= RULE_ID
                    {
                    lv_name_40_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_40_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_7_2_0_0_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_40_0,
                      									"org.xtext.FLY.ID");
                      							
                    }

                    }


                    }

                    otherlv_41=(Token)match(input,17,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_41, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_7_2_0_1());
                      					
                    }
                    // InternalFLY.g:1887:6: ( ( (lv_right_42_0= ruleArithmeticExpression ) ) | ( (lv_right_43_0= ruleObject ) ) )
                    int alt14=2;
                    switch ( input.LA(1) ) {
                    case RULE_ID:
                    case RULE_STRING:
                    case RULE_INT:
                    case RULE_FLOAT:
                    case 21:
                    case 46:
                    case 67:
                    case 68:
                    case 71:
                    case 80:
                    case 81:
                    case 82:
                        {
                        alt14=1;
                        }
                        break;
                    case 42:
                        {
                        switch ( input.LA(2) ) {
                        case RULE_INT:
                            {
                            int LA14_4 = input.LA(3);

                            if ( (LA14_4==30||LA14_4==43||(LA14_4>=59 && LA14_4<=70)||(LA14_4>=72 && LA14_4<=73)) ) {
                                alt14=2;
                            }
                            else if ( (LA14_4==45) ) {
                                alt14=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RULE_ID:
                            {
                            int LA14_5 = input.LA(3);

                            if ( (LA14_5==21||LA14_5==30||(LA14_5>=42 && LA14_5<=44)||(LA14_5>=49 && LA14_5<=50)||(LA14_5>=59 && LA14_5<=70)||(LA14_5>=72 && LA14_5<=73)) ) {
                                alt14=2;
                            }
                            else if ( (LA14_5==45) ) {
                                alt14=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RULE_STRING:
                        case RULE_FLOAT:
                        case 21:
                        case 30:
                        case 42:
                        case 43:
                        case 46:
                        case 67:
                        case 68:
                        case 71:
                        case 80:
                        case 81:
                        case 82:
                            {
                            alt14=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 2, input);

                            throw nvae;
                        }

                        }
                        break;
                    case 32:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                        {
                        alt14=2;
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
                            // InternalFLY.g:1888:7: ( (lv_right_42_0= ruleArithmeticExpression ) )
                            {
                            // InternalFLY.g:1888:7: ( (lv_right_42_0= ruleArithmeticExpression ) )
                            // InternalFLY.g:1889:8: (lv_right_42_0= ruleArithmeticExpression )
                            {
                            // InternalFLY.g:1889:8: (lv_right_42_0= ruleArithmeticExpression )
                            // InternalFLY.g:1890:9: lv_right_42_0= ruleArithmeticExpression
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightArithmeticExpressionParserRuleCall_7_2_0_2_0_0());
                              								
                            }
                            pushFollow(FOLLOW_2);
                            lv_right_42_0=ruleArithmeticExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                              									}
                              									set(
                              										current,
                              										"right",
                              										lv_right_42_0,
                              										"org.xtext.FLY.ArithmeticExpression");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalFLY.g:1908:7: ( (lv_right_43_0= ruleObject ) )
                            {
                            // InternalFLY.g:1908:7: ( (lv_right_43_0= ruleObject ) )
                            // InternalFLY.g:1909:8: (lv_right_43_0= ruleObject )
                            {
                            // InternalFLY.g:1909:8: (lv_right_43_0= ruleObject )
                            // InternalFLY.g:1910:9: lv_right_43_0= ruleObject
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightObjectParserRuleCall_7_2_0_2_1_0());
                              								
                            }
                            pushFollow(FOLLOW_2);
                            lv_right_43_0=ruleObject();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                              									}
                              									set(
                              										current,
                              										"right",
                              										lv_right_43_0,
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
    // InternalFLY.g:1935:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // InternalFLY.g:1935:47: (iv_ruleObject= ruleObject EOF )
            // InternalFLY.g:1936:2: iv_ruleObject= ruleObject EOF
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
    // InternalFLY.g:1942:1: ruleObject returns [EObject current=null] : ( ( () otherlv_1= '{' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= '}' ) | ( () ( (lv_type_7_0= ruleType ) ) ( (lv_indexes_8_0= ruleIndex ) ) ( (lv_indexes_9_0= ruleIndex ) )* ) | ( () otherlv_11= '[' ( (lv_values_12_0= ruleArrayValue ) )? (otherlv_13= ',' ( (lv_values_14_0= ruleArrayValue ) ) )* otherlv_15= ']' ) ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_features_2_0 = null;

        EObject lv_features_4_0 = null;

        AntlrDatatypeRuleToken lv_type_7_0 = null;

        EObject lv_indexes_8_0 = null;

        EObject lv_indexes_9_0 = null;

        EObject lv_values_12_0 = null;

        EObject lv_values_14_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:1948:2: ( ( ( () otherlv_1= '{' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= '}' ) | ( () ( (lv_type_7_0= ruleType ) ) ( (lv_indexes_8_0= ruleIndex ) ) ( (lv_indexes_9_0= ruleIndex ) )* ) | ( () otherlv_11= '[' ( (lv_values_12_0= ruleArrayValue ) )? (otherlv_13= ',' ( (lv_values_14_0= ruleArrayValue ) ) )* otherlv_15= ']' ) ) )
            // InternalFLY.g:1949:2: ( ( () otherlv_1= '{' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= '}' ) | ( () ( (lv_type_7_0= ruleType ) ) ( (lv_indexes_8_0= ruleIndex ) ) ( (lv_indexes_9_0= ruleIndex ) )* ) | ( () otherlv_11= '[' ( (lv_values_12_0= ruleArrayValue ) )? (otherlv_13= ',' ( (lv_values_14_0= ruleArrayValue ) ) )* otherlv_15= ']' ) )
            {
            // InternalFLY.g:1949:2: ( ( () otherlv_1= '{' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= '}' ) | ( () ( (lv_type_7_0= ruleType ) ) ( (lv_indexes_8_0= ruleIndex ) ) ( (lv_indexes_9_0= ruleIndex ) )* ) | ( () otherlv_11= '[' ( (lv_values_12_0= ruleArrayValue ) )? (otherlv_13= ',' ( (lv_values_14_0= ruleArrayValue ) ) )* otherlv_15= ']' ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt21=1;
                }
                break;
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                {
                alt21=2;
                }
                break;
            case 42:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalFLY.g:1950:3: ( () otherlv_1= '{' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= '}' )
                    {
                    // InternalFLY.g:1950:3: ( () otherlv_1= '{' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= '}' )
                    // InternalFLY.g:1951:4: () otherlv_1= '{' ( (lv_features_2_0= ruleFeautureName ) )? (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )* otherlv_5= '}'
                    {
                    // InternalFLY.g:1951:4: ()
                    // InternalFLY.g:1952:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectAccess().getNameObjectDefAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,32,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_0_1());
                      			
                    }
                    // InternalFLY.g:1962:4: ( (lv_features_2_0= ruleFeautureName ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_INT)||LA16_0==RULE_FLOAT||LA16_0==21||LA16_0==32||LA16_0==42||LA16_0==46||(LA16_0>=67 && LA16_0<=68)||LA16_0==71||(LA16_0>=74 && LA16_0<=82)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalFLY.g:1963:5: (lv_features_2_0= ruleFeautureName )
                            {
                            // InternalFLY.g:1963:5: (lv_features_2_0= ruleFeautureName )
                            // InternalFLY.g:1964:6: lv_features_2_0= ruleFeautureName
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeautureNameParserRuleCall_0_2_0());
                              					
                            }
                            pushFollow(FOLLOW_26);
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

                    // InternalFLY.g:1981:4: (otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==30) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalFLY.g:1982:5: otherlv_3= ',' ( (lv_features_4_0= ruleFeautureName ) )
                    	    {
                    	    otherlv_3=(Token)match(input,30,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getObjectAccess().getCommaKeyword_0_3_0());
                    	      				
                    	    }
                    	    // InternalFLY.g:1986:5: ( (lv_features_4_0= ruleFeautureName ) )
                    	    // InternalFLY.g:1987:6: (lv_features_4_0= ruleFeautureName )
                    	    {
                    	    // InternalFLY.g:1987:6: (lv_features_4_0= ruleFeautureName )
                    	    // InternalFLY.g:1988:7: lv_features_4_0= ruleFeautureName
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeautureNameParserRuleCall_0_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_26);
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
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:2012:3: ( () ( (lv_type_7_0= ruleType ) ) ( (lv_indexes_8_0= ruleIndex ) ) ( (lv_indexes_9_0= ruleIndex ) )* )
                    {
                    // InternalFLY.g:2012:3: ( () ( (lv_type_7_0= ruleType ) ) ( (lv_indexes_8_0= ruleIndex ) ) ( (lv_indexes_9_0= ruleIndex ) )* )
                    // InternalFLY.g:2013:4: () ( (lv_type_7_0= ruleType ) ) ( (lv_indexes_8_0= ruleIndex ) ) ( (lv_indexes_9_0= ruleIndex ) )*
                    {
                    // InternalFLY.g:2013:4: ()
                    // InternalFLY.g:2014:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectAccess().getArrayDefinitionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:2020:4: ( (lv_type_7_0= ruleType ) )
                    // InternalFLY.g:2021:5: (lv_type_7_0= ruleType )
                    {
                    // InternalFLY.g:2021:5: (lv_type_7_0= ruleType )
                    // InternalFLY.g:2022:6: lv_type_7_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getObjectAccess().getTypeTypeParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_22);
                    lv_type_7_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getObjectRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_7_0,
                      							"org.xtext.FLY.Type");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalFLY.g:2039:4: ( (lv_indexes_8_0= ruleIndex ) )
                    // InternalFLY.g:2040:5: (lv_indexes_8_0= ruleIndex )
                    {
                    // InternalFLY.g:2040:5: (lv_indexes_8_0= ruleIndex )
                    // InternalFLY.g:2041:6: lv_indexes_8_0= ruleIndex
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getObjectAccess().getIndexesIndexParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    lv_indexes_8_0=ruleIndex();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getObjectRule());
                      						}
                      						add(
                      							current,
                      							"indexes",
                      							lv_indexes_8_0,
                      							"org.xtext.FLY.Index");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalFLY.g:2058:4: ( (lv_indexes_9_0= ruleIndex ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==42) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalFLY.g:2059:5: (lv_indexes_9_0= ruleIndex )
                    	    {
                    	    // InternalFLY.g:2059:5: (lv_indexes_9_0= ruleIndex )
                    	    // InternalFLY.g:2060:6: lv_indexes_9_0= ruleIndex
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getObjectAccess().getIndexesIndexParserRuleCall_1_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_27);
                    	    lv_indexes_9_0=ruleIndex();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getObjectRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"indexes",
                    	      							lv_indexes_9_0,
                    	      							"org.xtext.FLY.Index");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalFLY.g:2079:3: ( () otherlv_11= '[' ( (lv_values_12_0= ruleArrayValue ) )? (otherlv_13= ',' ( (lv_values_14_0= ruleArrayValue ) ) )* otherlv_15= ']' )
                    {
                    // InternalFLY.g:2079:3: ( () otherlv_11= '[' ( (lv_values_12_0= ruleArrayValue ) )? (otherlv_13= ',' ( (lv_values_14_0= ruleArrayValue ) ) )* otherlv_15= ']' )
                    // InternalFLY.g:2080:4: () otherlv_11= '[' ( (lv_values_12_0= ruleArrayValue ) )? (otherlv_13= ',' ( (lv_values_14_0= ruleArrayValue ) ) )* otherlv_15= ']'
                    {
                    // InternalFLY.g:2080:4: ()
                    // InternalFLY.g:2081:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectAccess().getArrayInitAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_11=(Token)match(input,42,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getObjectAccess().getLeftSquareBracketKeyword_2_1());
                      			
                    }
                    // InternalFLY.g:2091:4: ( (lv_values_12_0= ruleArrayValue ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_INT)||LA19_0==RULE_FLOAT||LA19_0==21||LA19_0==42||LA19_0==46||(LA19_0>=67 && LA19_0<=68)||LA19_0==71||(LA19_0>=80 && LA19_0<=82)) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalFLY.g:2092:5: (lv_values_12_0= ruleArrayValue )
                            {
                            // InternalFLY.g:2092:5: (lv_values_12_0= ruleArrayValue )
                            // InternalFLY.g:2093:6: lv_values_12_0= ruleArrayValue
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getObjectAccess().getValuesArrayValueParserRuleCall_2_2_0());
                              					
                            }
                            pushFollow(FOLLOW_29);
                            lv_values_12_0=ruleArrayValue();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getObjectRule());
                              						}
                              						add(
                              							current,
                              							"values",
                              							lv_values_12_0,
                              							"org.xtext.FLY.ArrayValue");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalFLY.g:2110:4: (otherlv_13= ',' ( (lv_values_14_0= ruleArrayValue ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==30) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalFLY.g:2111:5: otherlv_13= ',' ( (lv_values_14_0= ruleArrayValue ) )
                    	    {
                    	    otherlv_13=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_13, grammarAccess.getObjectAccess().getCommaKeyword_2_3_0());
                    	      				
                    	    }
                    	    // InternalFLY.g:2115:5: ( (lv_values_14_0= ruleArrayValue ) )
                    	    // InternalFLY.g:2116:6: (lv_values_14_0= ruleArrayValue )
                    	    {
                    	    // InternalFLY.g:2116:6: (lv_values_14_0= ruleArrayValue )
                    	    // InternalFLY.g:2117:7: lv_values_14_0= ruleArrayValue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getObjectAccess().getValuesArrayValueParserRuleCall_2_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_29);
                    	    lv_values_14_0=ruleArrayValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getObjectRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"values",
                    	      								lv_values_14_0,
                    	      								"org.xtext.FLY.ArrayValue");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getObjectAccess().getRightSquareBracketKeyword_2_4());
                      			
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
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleIndex"
    // InternalFLY.g:2144:1: entryRuleIndex returns [EObject current=null] : iv_ruleIndex= ruleIndex EOF ;
    public final EObject entryRuleIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndex = null;


        try {
            // InternalFLY.g:2144:46: (iv_ruleIndex= ruleIndex EOF )
            // InternalFLY.g:2145:2: iv_ruleIndex= ruleIndex EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndexRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIndex=ruleIndex();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndex; 
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
    // $ANTLR end "entryRuleIndex"


    // $ANTLR start "ruleIndex"
    // InternalFLY.g:2151:1: ruleIndex returns [EObject current=null] : (otherlv_0= '[' ( (lv_value_1_0= ruleArithmeticExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleIndex() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:2157:2: ( (otherlv_0= '[' ( (lv_value_1_0= ruleArithmeticExpression ) ) otherlv_2= ']' ) )
            // InternalFLY.g:2158:2: (otherlv_0= '[' ( (lv_value_1_0= ruleArithmeticExpression ) ) otherlv_2= ']' )
            {
            // InternalFLY.g:2158:2: (otherlv_0= '[' ( (lv_value_1_0= ruleArithmeticExpression ) ) otherlv_2= ']' )
            // InternalFLY.g:2159:3: otherlv_0= '[' ( (lv_value_1_0= ruleArithmeticExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIndexAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalFLY.g:2163:3: ( (lv_value_1_0= ruleArithmeticExpression ) )
            // InternalFLY.g:2164:4: (lv_value_1_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:2164:4: (lv_value_1_0= ruleArithmeticExpression )
            // InternalFLY.g:2165:5: lv_value_1_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIndexAccess().getValueArithmeticExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_30);
            lv_value_1_0=ruleArithmeticExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIndexRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.xtext.FLY.ArithmeticExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getIndexAccess().getRightSquareBracketKeyword_2());
              		
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
    // $ANTLR end "ruleIndex"


    // $ANTLR start "entryRuleArrayValue"
    // InternalFLY.g:2190:1: entryRuleArrayValue returns [EObject current=null] : iv_ruleArrayValue= ruleArrayValue EOF ;
    public final EObject entryRuleArrayValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayValue = null;


        try {
            // InternalFLY.g:2190:51: (iv_ruleArrayValue= ruleArrayValue EOF )
            // InternalFLY.g:2191:2: iv_ruleArrayValue= ruleArrayValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayValue=ruleArrayValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayValue; 
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
    // $ANTLR end "entryRuleArrayValue"


    // $ANTLR start "ruleArrayValue"
    // InternalFLY.g:2197:1: ruleArrayValue returns [EObject current=null] : ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleArrayValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleArrayValue ) ) )* otherlv_5= ']' ) | this_ArithmeticExpression_6= ruleArithmeticExpression ) ;
    public final EObject ruleArrayValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;

        EObject this_ArithmeticExpression_6 = null;



        	enterRule();

        try {
            // InternalFLY.g:2203:2: ( ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleArrayValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleArrayValue ) ) )* otherlv_5= ']' ) | this_ArithmeticExpression_6= ruleArithmeticExpression ) )
            // InternalFLY.g:2204:2: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleArrayValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleArrayValue ) ) )* otherlv_5= ']' ) | this_ArithmeticExpression_6= ruleArithmeticExpression )
            {
            // InternalFLY.g:2204:2: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleArrayValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleArrayValue ) ) )* otherlv_5= ']' ) | this_ArithmeticExpression_6= ruleArithmeticExpression )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==42) ) {
                switch ( input.LA(2) ) {
                case RULE_INT:
                    {
                    int LA24_3 = input.LA(3);

                    if ( (LA24_3==45) ) {
                        alt24=2;
                    }
                    else if ( (LA24_3==30||LA24_3==43||(LA24_3>=59 && LA24_3<=70)||(LA24_3>=72 && LA24_3<=73)) ) {
                        alt24=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_ID:
                    {
                    int LA24_4 = input.LA(3);

                    if ( (LA24_4==45) ) {
                        alt24=2;
                    }
                    else if ( (LA24_4==21||LA24_4==30||(LA24_4>=42 && LA24_4<=44)||(LA24_4>=49 && LA24_4<=50)||(LA24_4>=59 && LA24_4<=70)||(LA24_4>=72 && LA24_4<=73)) ) {
                        alt24=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_STRING:
                case RULE_FLOAT:
                case 21:
                case 30:
                case 42:
                case 43:
                case 46:
                case 67:
                case 68:
                case 71:
                case 80:
                case 81:
                case 82:
                    {
                    alt24=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }

            }
            else if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_INT)||LA24_0==RULE_FLOAT||LA24_0==21||LA24_0==46||(LA24_0>=67 && LA24_0<=68)||LA24_0==71||(LA24_0>=80 && LA24_0<=82)) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalFLY.g:2205:3: ( () otherlv_1= '[' ( (lv_values_2_0= ruleArrayValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleArrayValue ) ) )* otherlv_5= ']' )
                    {
                    // InternalFLY.g:2205:3: ( () otherlv_1= '[' ( (lv_values_2_0= ruleArrayValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleArrayValue ) ) )* otherlv_5= ']' )
                    // InternalFLY.g:2206:4: () otherlv_1= '[' ( (lv_values_2_0= ruleArrayValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleArrayValue ) ) )* otherlv_5= ']'
                    {
                    // InternalFLY.g:2206:4: ()
                    // InternalFLY.g:2207:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getArrayValueAccess().getArrayValueAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getArrayValueAccess().getLeftSquareBracketKeyword_0_1());
                      			
                    }
                    // InternalFLY.g:2217:4: ( (lv_values_2_0= ruleArrayValue ) )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_INT)||LA22_0==RULE_FLOAT||LA22_0==21||LA22_0==42||LA22_0==46||(LA22_0>=67 && LA22_0<=68)||LA22_0==71||(LA22_0>=80 && LA22_0<=82)) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalFLY.g:2218:5: (lv_values_2_0= ruleArrayValue )
                            {
                            // InternalFLY.g:2218:5: (lv_values_2_0= ruleArrayValue )
                            // InternalFLY.g:2219:6: lv_values_2_0= ruleArrayValue
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getArrayValueAccess().getValuesArrayValueParserRuleCall_0_2_0());
                              					
                            }
                            pushFollow(FOLLOW_29);
                            lv_values_2_0=ruleArrayValue();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getArrayValueRule());
                              						}
                              						add(
                              							current,
                              							"values",
                              							lv_values_2_0,
                              							"org.xtext.FLY.ArrayValue");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalFLY.g:2236:4: (otherlv_3= ',' ( (lv_values_4_0= ruleArrayValue ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==30) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalFLY.g:2237:5: otherlv_3= ',' ( (lv_values_4_0= ruleArrayValue ) )
                    	    {
                    	    otherlv_3=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getArrayValueAccess().getCommaKeyword_0_3_0());
                    	      				
                    	    }
                    	    // InternalFLY.g:2241:5: ( (lv_values_4_0= ruleArrayValue ) )
                    	    // InternalFLY.g:2242:6: (lv_values_4_0= ruleArrayValue )
                    	    {
                    	    // InternalFLY.g:2242:6: (lv_values_4_0= ruleArrayValue )
                    	    // InternalFLY.g:2243:7: lv_values_4_0= ruleArrayValue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getArrayValueAccess().getValuesArrayValueParserRuleCall_0_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_29);
                    	    lv_values_4_0=ruleArrayValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getArrayValueRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"values",
                    	      								lv_values_4_0,
                    	      								"org.xtext.FLY.ArrayValue");
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

                    otherlv_5=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getArrayValueAccess().getRightSquareBracketKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:2267:3: this_ArithmeticExpression_6= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getArrayValueAccess().getArithmeticExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArithmeticExpression_6=ruleArithmeticExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArithmeticExpression_6;
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
    // $ANTLR end "ruleArrayValue"


    // $ANTLR start "entryRuleDeclarationObject"
    // InternalFLY.g:2279:1: entryRuleDeclarationObject returns [EObject current=null] : iv_ruleDeclarationObject= ruleDeclarationObject EOF ;
    public final EObject entryRuleDeclarationObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationObject = null;


        try {
            // InternalFLY.g:2279:58: (iv_ruleDeclarationObject= ruleDeclarationObject EOF )
            // InternalFLY.g:2280:2: iv_ruleDeclarationObject= ruleDeclarationObject EOF
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
    // InternalFLY.g:2286:1: ruleDeclarationObject returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_features_2_0= ruleDeclarationFeature ) ) (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleDeclarationObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_features_2_0 = null;

        EObject lv_features_4_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:2292:2: ( ( () otherlv_1= '[' ( (lv_features_2_0= ruleDeclarationFeature ) ) (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )* otherlv_5= ']' ) )
            // InternalFLY.g:2293:2: ( () otherlv_1= '[' ( (lv_features_2_0= ruleDeclarationFeature ) ) (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )* otherlv_5= ']' )
            {
            // InternalFLY.g:2293:2: ( () otherlv_1= '[' ( (lv_features_2_0= ruleDeclarationFeature ) ) (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )* otherlv_5= ']' )
            // InternalFLY.g:2294:3: () otherlv_1= '[' ( (lv_features_2_0= ruleDeclarationFeature ) ) (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )* otherlv_5= ']'
            {
            // InternalFLY.g:2294:3: ()
            // InternalFLY.g:2295:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDeclarationObjectAccess().getDeclarationObjectAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,42,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDeclarationObjectAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalFLY.g:2305:3: ( (lv_features_2_0= ruleDeclarationFeature ) )
            // InternalFLY.g:2306:4: (lv_features_2_0= ruleDeclarationFeature )
            {
            // InternalFLY.g:2306:4: (lv_features_2_0= ruleDeclarationFeature )
            // InternalFLY.g:2307:5: lv_features_2_0= ruleDeclarationFeature
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclarationObjectAccess().getFeaturesDeclarationFeatureParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_29);
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

            // InternalFLY.g:2324:3: (otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==30) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalFLY.g:2325:4: otherlv_3= ',' ( (lv_features_4_0= ruleDeclarationFeature ) )
            	    {
            	    otherlv_3=(Token)match(input,30,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getDeclarationObjectAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalFLY.g:2329:4: ( (lv_features_4_0= ruleDeclarationFeature ) )
            	    // InternalFLY.g:2330:5: (lv_features_4_0= ruleDeclarationFeature )
            	    {
            	    // InternalFLY.g:2330:5: (lv_features_4_0= ruleDeclarationFeature )
            	    // InternalFLY.g:2331:6: lv_features_4_0= ruleDeclarationFeature
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDeclarationObjectAccess().getFeaturesDeclarationFeatureParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
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
            	    break loop25;
                }
            } while (true);

            otherlv_5=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalFLY.g:2357:1: entryRuleDeclarationFeature returns [EObject current=null] : iv_ruleDeclarationFeature= ruleDeclarationFeature EOF ;
    public final EObject entryRuleDeclarationFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationFeature = null;


        try {
            // InternalFLY.g:2357:59: (iv_ruleDeclarationFeature= ruleDeclarationFeature EOF )
            // InternalFLY.g:2358:2: iv_ruleDeclarationFeature= ruleDeclarationFeature EOF
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
    // InternalFLY.g:2364:1: ruleDeclarationFeature returns [EObject current=null] : ( () ( (lv_feature_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) ) ) ;
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
            // InternalFLY.g:2370:2: ( ( () ( (lv_feature_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) ) ) )
            // InternalFLY.g:2371:2: ( () ( (lv_feature_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) ) )
            {
            // InternalFLY.g:2371:2: ( () ( (lv_feature_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) ) )
            // InternalFLY.g:2372:3: () ( (lv_feature_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) )
            {
            // InternalFLY.g:2372:3: ()
            // InternalFLY.g:2373:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDeclarationFeatureAccess().getDeclarationFeatureAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:2379:3: ( (lv_feature_1_0= RULE_ID ) )
            // InternalFLY.g:2380:4: (lv_feature_1_0= RULE_ID )
            {
            // InternalFLY.g:2380:4: (lv_feature_1_0= RULE_ID )
            // InternalFLY.g:2381:5: lv_feature_1_0= RULE_ID
            {
            lv_feature_1_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,17,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDeclarationFeatureAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalFLY.g:2401:3: ( ( (lv_value_f_3_0= RULE_ID ) ) | ( (lv_value_s_4_0= RULE_STRING ) ) | ( (lv_value_t_5_0= RULE_INT ) ) | ( (lv_value_b_6_0= ruleBooleanLiteral ) ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt26=1;
                }
                break;
            case RULE_STRING:
                {
                alt26=2;
                }
                break;
            case RULE_INT:
                {
                alt26=3;
                }
                break;
            case 81:
            case 82:
                {
                alt26=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalFLY.g:2402:4: ( (lv_value_f_3_0= RULE_ID ) )
                    {
                    // InternalFLY.g:2402:4: ( (lv_value_f_3_0= RULE_ID ) )
                    // InternalFLY.g:2403:5: (lv_value_f_3_0= RULE_ID )
                    {
                    // InternalFLY.g:2403:5: (lv_value_f_3_0= RULE_ID )
                    // InternalFLY.g:2404:6: lv_value_f_3_0= RULE_ID
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
                    // InternalFLY.g:2421:4: ( (lv_value_s_4_0= RULE_STRING ) )
                    {
                    // InternalFLY.g:2421:4: ( (lv_value_s_4_0= RULE_STRING ) )
                    // InternalFLY.g:2422:5: (lv_value_s_4_0= RULE_STRING )
                    {
                    // InternalFLY.g:2422:5: (lv_value_s_4_0= RULE_STRING )
                    // InternalFLY.g:2423:6: lv_value_s_4_0= RULE_STRING
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
                    // InternalFLY.g:2440:4: ( (lv_value_t_5_0= RULE_INT ) )
                    {
                    // InternalFLY.g:2440:4: ( (lv_value_t_5_0= RULE_INT ) )
                    // InternalFLY.g:2441:5: (lv_value_t_5_0= RULE_INT )
                    {
                    // InternalFLY.g:2441:5: (lv_value_t_5_0= RULE_INT )
                    // InternalFLY.g:2442:6: lv_value_t_5_0= RULE_INT
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
                    // InternalFLY.g:2459:4: ( (lv_value_b_6_0= ruleBooleanLiteral ) )
                    {
                    // InternalFLY.g:2459:4: ( (lv_value_b_6_0= ruleBooleanLiteral ) )
                    // InternalFLY.g:2460:5: (lv_value_b_6_0= ruleBooleanLiteral )
                    {
                    // InternalFLY.g:2460:5: (lv_value_b_6_0= ruleBooleanLiteral )
                    // InternalFLY.g:2461:6: lv_value_b_6_0= ruleBooleanLiteral
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
    // InternalFLY.g:2483:1: entryRuleFeautureName returns [EObject current=null] : iv_ruleFeautureName= ruleFeautureName EOF ;
    public final EObject entryRuleFeautureName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeautureName = null;


        try {
            // InternalFLY.g:2483:53: (iv_ruleFeautureName= ruleFeautureName EOF )
            // InternalFLY.g:2484:2: iv_ruleFeautureName= ruleFeautureName EOF
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
    // InternalFLY.g:2490:1: ruleFeautureName returns [EObject current=null] : ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleArithmeticExpression ) ) ) | ( (lv_value_3_0= ruleArithmeticExpression ) ) | this_Object_4= ruleObject ) ;
    public final EObject ruleFeautureName() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_3_0 = null;

        EObject this_Object_4 = null;



        	enterRule();

        try {
            // InternalFLY.g:2496:2: ( ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleArithmeticExpression ) ) ) | ( (lv_value_3_0= ruleArithmeticExpression ) ) | this_Object_4= ruleObject ) )
            // InternalFLY.g:2497:2: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleArithmeticExpression ) ) ) | ( (lv_value_3_0= ruleArithmeticExpression ) ) | this_Object_4= ruleObject )
            {
            // InternalFLY.g:2497:2: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleArithmeticExpression ) ) ) | ( (lv_value_3_0= ruleArithmeticExpression ) ) | this_Object_4= ruleObject )
            int alt27=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==EOF||LA27_1==21||LA27_1==30||LA27_1==33||LA27_1==42||LA27_1==44||(LA27_1>=49 && LA27_1<=50)||(LA27_1>=59 && LA27_1<=70)||(LA27_1>=72 && LA27_1<=73)) ) {
                    alt27=2;
                }
                else if ( (LA27_1==17) ) {
                    alt27=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case RULE_FLOAT:
            case 21:
            case 46:
            case 67:
            case 68:
            case 71:
            case 80:
            case 81:
            case 82:
                {
                alt27=2;
                }
                break;
            case 42:
                {
                switch ( input.LA(2) ) {
                case RULE_INT:
                    {
                    int LA27_6 = input.LA(3);

                    if ( (LA27_6==30||LA27_6==43||(LA27_6>=59 && LA27_6<=70)||(LA27_6>=72 && LA27_6<=73)) ) {
                        alt27=3;
                    }
                    else if ( (LA27_6==45) ) {
                        alt27=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 6, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_ID:
                    {
                    int LA27_7 = input.LA(3);

                    if ( (LA27_7==21||LA27_7==30||(LA27_7>=42 && LA27_7<=44)||(LA27_7>=49 && LA27_7<=50)||(LA27_7>=59 && LA27_7<=70)||(LA27_7>=72 && LA27_7<=73)) ) {
                        alt27=3;
                    }
                    else if ( (LA27_7==45) ) {
                        alt27=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 7, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_STRING:
                case RULE_FLOAT:
                case 21:
                case 30:
                case 42:
                case 43:
                case 46:
                case 67:
                case 68:
                case 71:
                case 80:
                case 81:
                case 82:
                    {
                    alt27=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 3, input);

                    throw nvae;
                }

                }
                break;
            case 32:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                {
                alt27=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalFLY.g:2498:3: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleArithmeticExpression ) ) )
                    {
                    // InternalFLY.g:2498:3: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleArithmeticExpression ) ) )
                    // InternalFLY.g:2499:4: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleArithmeticExpression ) )
                    {
                    // InternalFLY.g:2499:4: ( (lv_feature_0_0= RULE_ID ) )
                    // InternalFLY.g:2500:5: (lv_feature_0_0= RULE_ID )
                    {
                    // InternalFLY.g:2500:5: (lv_feature_0_0= RULE_ID )
                    // InternalFLY.g:2501:6: lv_feature_0_0= RULE_ID
                    {
                    lv_feature_0_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
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

                    otherlv_1=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getFeautureNameAccess().getEqualsSignKeyword_0_1());
                      			
                    }
                    // InternalFLY.g:2521:4: ( (lv_value_2_0= ruleArithmeticExpression ) )
                    // InternalFLY.g:2522:5: (lv_value_2_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:2522:5: (lv_value_2_0= ruleArithmeticExpression )
                    // InternalFLY.g:2523:6: lv_value_2_0= ruleArithmeticExpression
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
                    // InternalFLY.g:2542:3: ( (lv_value_3_0= ruleArithmeticExpression ) )
                    {
                    // InternalFLY.g:2542:3: ( (lv_value_3_0= ruleArithmeticExpression ) )
                    // InternalFLY.g:2543:4: (lv_value_3_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:2543:4: (lv_value_3_0= ruleArithmeticExpression )
                    // InternalFLY.g:2544:5: lv_value_3_0= ruleArithmeticExpression
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
                case 3 :
                    // InternalFLY.g:2562:3: this_Object_4= ruleObject
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFeautureNameAccess().getObjectParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Object_4=ruleObject();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Object_4;
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
    // $ANTLR end "ruleFeautureName"


    // $ANTLR start "entryRuleObjectLiteral"
    // InternalFLY.g:2574:1: entryRuleObjectLiteral returns [EObject current=null] : iv_ruleObjectLiteral= ruleObjectLiteral EOF ;
    public final EObject entryRuleObjectLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectLiteral = null;


        try {
            // InternalFLY.g:2574:54: (iv_ruleObjectLiteral= ruleObjectLiteral EOF )
            // InternalFLY.g:2575:2: iv_ruleObjectLiteral= ruleObjectLiteral EOF
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
    // InternalFLY.g:2581:1: ruleObjectLiteral returns [EObject current=null] : ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) | ( () ( (otherlv_5= RULE_ID ) ) ( (lv_indexes_6_0= ruleSubIndex ) ) ( (lv_indexes_7_0= ruleSubIndex ) )* ) | ( () ( (otherlv_9= RULE_ID ) ) otherlv_10= '[' ( ( (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral ) ) ) otherlv_12= ',' ( ( (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral ) ) ) otherlv_14= ']' ) | ( () ( (otherlv_16= RULE_ID ) ) otherlv_17= '[' ( ( (lv_range1_18_0= ruleRangeLiteral ) ) | ( (lv_range1_t_19_0= ruleNumberLiteral ) ) ) otherlv_20= ',' ( (lv_range2_21_0= ruleRangeLiteral ) ) otherlv_22= ']' ) ) ;
    public final EObject ruleObjectLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        EObject lv_indexes_6_0 = null;

        EObject lv_indexes_7_0 = null;

        EObject lv_value1_11_1 = null;

        EObject lv_value1_11_2 = null;

        EObject lv_value2_13_1 = null;

        EObject lv_value2_13_2 = null;

        EObject lv_range1_18_0 = null;

        EObject lv_range1_t_19_0 = null;

        EObject lv_range2_21_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:2587:2: ( ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) | ( () ( (otherlv_5= RULE_ID ) ) ( (lv_indexes_6_0= ruleSubIndex ) ) ( (lv_indexes_7_0= ruleSubIndex ) )* ) | ( () ( (otherlv_9= RULE_ID ) ) otherlv_10= '[' ( ( (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral ) ) ) otherlv_12= ',' ( ( (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral ) ) ) otherlv_14= ']' ) | ( () ( (otherlv_16= RULE_ID ) ) otherlv_17= '[' ( ( (lv_range1_18_0= ruleRangeLiteral ) ) | ( (lv_range1_t_19_0= ruleNumberLiteral ) ) ) otherlv_20= ',' ( (lv_range2_21_0= ruleRangeLiteral ) ) otherlv_22= ']' ) ) )
            // InternalFLY.g:2588:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) | ( () ( (otherlv_5= RULE_ID ) ) ( (lv_indexes_6_0= ruleSubIndex ) ) ( (lv_indexes_7_0= ruleSubIndex ) )* ) | ( () ( (otherlv_9= RULE_ID ) ) otherlv_10= '[' ( ( (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral ) ) ) otherlv_12= ',' ( ( (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral ) ) ) otherlv_14= ']' ) | ( () ( (otherlv_16= RULE_ID ) ) otherlv_17= '[' ( ( (lv_range1_18_0= ruleRangeLiteral ) ) | ( (lv_range1_t_19_0= ruleNumberLiteral ) ) ) otherlv_20= ',' ( (lv_range2_21_0= ruleRangeLiteral ) ) otherlv_22= ']' ) )
            {
            // InternalFLY.g:2588:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) | ( () ( (otherlv_5= RULE_ID ) ) ( (lv_indexes_6_0= ruleSubIndex ) ) ( (lv_indexes_7_0= ruleSubIndex ) )* ) | ( () ( (otherlv_9= RULE_ID ) ) otherlv_10= '[' ( ( (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral ) ) ) otherlv_12= ',' ( ( (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral ) ) ) otherlv_14= ']' ) | ( () ( (otherlv_16= RULE_ID ) ) otherlv_17= '[' ( ( (lv_range1_18_0= ruleRangeLiteral ) ) | ( (lv_range1_t_19_0= ruleNumberLiteral ) ) ) otherlv_20= ',' ( (lv_range2_21_0= ruleRangeLiteral ) ) otherlv_22= ']' ) )
            int alt32=4;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalFLY.g:2589:3: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) )
                    {
                    // InternalFLY.g:2589:3: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) )
                    // InternalFLY.g:2590:4: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) )
                    {
                    // InternalFLY.g:2590:4: ()
                    // InternalFLY.g:2591:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectLiteralAccess().getNameObjectAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:2597:4: ( (otherlv_1= RULE_ID ) )
                    // InternalFLY.g:2598:5: (otherlv_1= RULE_ID )
                    {
                    // InternalFLY.g:2598:5: (otherlv_1= RULE_ID )
                    // InternalFLY.g:2599:6: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getObjectLiteralRule());
                      						}
                      					
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_1, grammarAccess.getObjectLiteralAccess().getNameVariableDeclarationCrossReference_0_1_0());
                      					
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,44,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getObjectLiteralAccess().getFullStopKeyword_0_2());
                      			
                    }
                    // InternalFLY.g:2614:4: ( (lv_value_3_0= RULE_ID ) )
                    // InternalFLY.g:2615:5: (lv_value_3_0= RULE_ID )
                    {
                    // InternalFLY.g:2615:5: (lv_value_3_0= RULE_ID )
                    // InternalFLY.g:2616:6: lv_value_3_0= RULE_ID
                    {
                    lv_value_3_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_0, grammarAccess.getObjectLiteralAccess().getValueIDTerminalRuleCall_0_3_0());
                      					
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
                    break;
                case 2 :
                    // InternalFLY.g:2634:3: ( () ( (otherlv_5= RULE_ID ) ) ( (lv_indexes_6_0= ruleSubIndex ) ) ( (lv_indexes_7_0= ruleSubIndex ) )* )
                    {
                    // InternalFLY.g:2634:3: ( () ( (otherlv_5= RULE_ID ) ) ( (lv_indexes_6_0= ruleSubIndex ) ) ( (lv_indexes_7_0= ruleSubIndex ) )* )
                    // InternalFLY.g:2635:4: () ( (otherlv_5= RULE_ID ) ) ( (lv_indexes_6_0= ruleSubIndex ) ) ( (lv_indexes_7_0= ruleSubIndex ) )*
                    {
                    // InternalFLY.g:2635:4: ()
                    // InternalFLY.g:2636:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectLiteralAccess().getIndexObjectAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:2642:4: ( (otherlv_5= RULE_ID ) )
                    // InternalFLY.g:2643:5: (otherlv_5= RULE_ID )
                    {
                    // InternalFLY.g:2643:5: (otherlv_5= RULE_ID )
                    // InternalFLY.g:2644:6: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getObjectLiteralRule());
                      						}
                      					
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_5, grammarAccess.getObjectLiteralAccess().getNameVariableDeclarationCrossReference_1_1_0());
                      					
                    }

                    }


                    }

                    // InternalFLY.g:2655:4: ( (lv_indexes_6_0= ruleSubIndex ) )
                    // InternalFLY.g:2656:5: (lv_indexes_6_0= ruleSubIndex )
                    {
                    // InternalFLY.g:2656:5: (lv_indexes_6_0= ruleSubIndex )
                    // InternalFLY.g:2657:6: lv_indexes_6_0= ruleSubIndex
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getObjectLiteralAccess().getIndexesSubIndexParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    lv_indexes_6_0=ruleSubIndex();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                      						}
                      						add(
                      							current,
                      							"indexes",
                      							lv_indexes_6_0,
                      							"org.xtext.FLY.SubIndex");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalFLY.g:2674:4: ( (lv_indexes_7_0= ruleSubIndex ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==42) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalFLY.g:2675:5: (lv_indexes_7_0= ruleSubIndex )
                    	    {
                    	    // InternalFLY.g:2675:5: (lv_indexes_7_0= ruleSubIndex )
                    	    // InternalFLY.g:2676:6: lv_indexes_7_0= ruleSubIndex
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getObjectLiteralAccess().getIndexesSubIndexParserRuleCall_1_3_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_27);
                    	    lv_indexes_7_0=ruleSubIndex();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"indexes",
                    	      							lv_indexes_7_0,
                    	      							"org.xtext.FLY.SubIndex");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalFLY.g:2695:3: ( () ( (otherlv_9= RULE_ID ) ) otherlv_10= '[' ( ( (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral ) ) ) otherlv_12= ',' ( ( (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral ) ) ) otherlv_14= ']' )
                    {
                    // InternalFLY.g:2695:3: ( () ( (otherlv_9= RULE_ID ) ) otherlv_10= '[' ( ( (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral ) ) ) otherlv_12= ',' ( ( (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral ) ) ) otherlv_14= ']' )
                    // InternalFLY.g:2696:4: () ( (otherlv_9= RULE_ID ) ) otherlv_10= '[' ( ( (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral ) ) ) otherlv_12= ',' ( ( (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral ) ) ) otherlv_14= ']'
                    {
                    // InternalFLY.g:2696:4: ()
                    // InternalFLY.g:2697:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectLiteralAccess().getDatSingleObjectAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:2703:4: ( (otherlv_9= RULE_ID ) )
                    // InternalFLY.g:2704:5: (otherlv_9= RULE_ID )
                    {
                    // InternalFLY.g:2704:5: (otherlv_9= RULE_ID )
                    // InternalFLY.g:2705:6: otherlv_9= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getObjectLiteralRule());
                      						}
                      					
                    }
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_9, grammarAccess.getObjectLiteralAccess().getNameDatDeclarationCrossReference_2_1_0());
                      					
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,42,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getObjectLiteralAccess().getLeftSquareBracketKeyword_2_2());
                      			
                    }
                    // InternalFLY.g:2720:4: ( ( (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral ) ) )
                    // InternalFLY.g:2721:5: ( (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral ) )
                    {
                    // InternalFLY.g:2721:5: ( (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral ) )
                    // InternalFLY.g:2722:6: (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral )
                    {
                    // InternalFLY.g:2722:6: (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==RULE_INT) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==RULE_STRING) ) {
                        alt29=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalFLY.g:2723:7: lv_value1_11_1= ruleNumberLiteral
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getObjectLiteralAccess().getValue1NumberLiteralParserRuleCall_2_3_0_0());
                              						
                            }
                            pushFollow(FOLLOW_34);
                            lv_value1_11_1=ruleNumberLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              							}
                              							set(
                              								current,
                              								"value1",
                              								lv_value1_11_1,
                              								"org.xtext.FLY.NumberLiteral");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalFLY.g:2739:7: lv_value1_11_2= ruleStringLiteral
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getObjectLiteralAccess().getValue1StringLiteralParserRuleCall_2_3_0_1());
                              						
                            }
                            pushFollow(FOLLOW_34);
                            lv_value1_11_2=ruleStringLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              							}
                              							set(
                              								current,
                              								"value1",
                              								lv_value1_11_2,
                              								"org.xtext.FLY.StringLiteral");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_12=(Token)match(input,30,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getObjectLiteralAccess().getCommaKeyword_2_4());
                      			
                    }
                    // InternalFLY.g:2761:4: ( ( (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral ) ) )
                    // InternalFLY.g:2762:5: ( (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral ) )
                    {
                    // InternalFLY.g:2762:5: ( (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral ) )
                    // InternalFLY.g:2763:6: (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral )
                    {
                    // InternalFLY.g:2763:6: (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==RULE_INT) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==RULE_STRING) ) {
                        alt30=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalFLY.g:2764:7: lv_value2_13_1= ruleNumberLiteral
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getObjectLiteralAccess().getValue2NumberLiteralParserRuleCall_2_5_0_0());
                              						
                            }
                            pushFollow(FOLLOW_30);
                            lv_value2_13_1=ruleNumberLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              							}
                              							set(
                              								current,
                              								"value2",
                              								lv_value2_13_1,
                              								"org.xtext.FLY.NumberLiteral");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalFLY.g:2780:7: lv_value2_13_2= ruleStringLiteral
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getObjectLiteralAccess().getValue2StringLiteralParserRuleCall_2_5_0_1());
                              						
                            }
                            pushFollow(FOLLOW_30);
                            lv_value2_13_2=ruleStringLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              							}
                              							set(
                              								current,
                              								"value2",
                              								lv_value2_13_2,
                              								"org.xtext.FLY.StringLiteral");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_14=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getObjectLiteralAccess().getRightSquareBracketKeyword_2_6());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalFLY.g:2804:3: ( () ( (otherlv_16= RULE_ID ) ) otherlv_17= '[' ( ( (lv_range1_18_0= ruleRangeLiteral ) ) | ( (lv_range1_t_19_0= ruleNumberLiteral ) ) ) otherlv_20= ',' ( (lv_range2_21_0= ruleRangeLiteral ) ) otherlv_22= ']' )
                    {
                    // InternalFLY.g:2804:3: ( () ( (otherlv_16= RULE_ID ) ) otherlv_17= '[' ( ( (lv_range1_18_0= ruleRangeLiteral ) ) | ( (lv_range1_t_19_0= ruleNumberLiteral ) ) ) otherlv_20= ',' ( (lv_range2_21_0= ruleRangeLiteral ) ) otherlv_22= ']' )
                    // InternalFLY.g:2805:4: () ( (otherlv_16= RULE_ID ) ) otherlv_17= '[' ( ( (lv_range1_18_0= ruleRangeLiteral ) ) | ( (lv_range1_t_19_0= ruleNumberLiteral ) ) ) otherlv_20= ',' ( (lv_range2_21_0= ruleRangeLiteral ) ) otherlv_22= ']'
                    {
                    // InternalFLY.g:2805:4: ()
                    // InternalFLY.g:2806:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getObjectLiteralAccess().getDatTableObjectAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:2812:4: ( (otherlv_16= RULE_ID ) )
                    // InternalFLY.g:2813:5: (otherlv_16= RULE_ID )
                    {
                    // InternalFLY.g:2813:5: (otherlv_16= RULE_ID )
                    // InternalFLY.g:2814:6: otherlv_16= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getObjectLiteralRule());
                      						}
                      					
                    }
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_16, grammarAccess.getObjectLiteralAccess().getNameDatDeclarationCrossReference_3_1_0());
                      					
                    }

                    }


                    }

                    otherlv_17=(Token)match(input,42,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getObjectLiteralAccess().getLeftSquareBracketKeyword_3_2());
                      			
                    }
                    // InternalFLY.g:2829:4: ( ( (lv_range1_18_0= ruleRangeLiteral ) ) | ( (lv_range1_t_19_0= ruleNumberLiteral ) ) )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==42) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==RULE_INT) ) {
                        alt31=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalFLY.g:2830:5: ( (lv_range1_18_0= ruleRangeLiteral ) )
                            {
                            // InternalFLY.g:2830:5: ( (lv_range1_18_0= ruleRangeLiteral ) )
                            // InternalFLY.g:2831:6: (lv_range1_18_0= ruleRangeLiteral )
                            {
                            // InternalFLY.g:2831:6: (lv_range1_18_0= ruleRangeLiteral )
                            // InternalFLY.g:2832:7: lv_range1_18_0= ruleRangeLiteral
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getObjectLiteralAccess().getRange1RangeLiteralParserRuleCall_3_3_0_0());
                              						
                            }
                            pushFollow(FOLLOW_34);
                            lv_range1_18_0=ruleRangeLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              							}
                              							set(
                              								current,
                              								"range1",
                              								lv_range1_18_0,
                              								"org.xtext.FLY.RangeLiteral");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalFLY.g:2850:5: ( (lv_range1_t_19_0= ruleNumberLiteral ) )
                            {
                            // InternalFLY.g:2850:5: ( (lv_range1_t_19_0= ruleNumberLiteral ) )
                            // InternalFLY.g:2851:6: (lv_range1_t_19_0= ruleNumberLiteral )
                            {
                            // InternalFLY.g:2851:6: (lv_range1_t_19_0= ruleNumberLiteral )
                            // InternalFLY.g:2852:7: lv_range1_t_19_0= ruleNumberLiteral
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getObjectLiteralAccess().getRange1_tNumberLiteralParserRuleCall_3_3_1_0());
                              						
                            }
                            pushFollow(FOLLOW_34);
                            lv_range1_t_19_0=ruleNumberLiteral();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                              							}
                              							set(
                              								current,
                              								"range1_t",
                              								lv_range1_t_19_0,
                              								"org.xtext.FLY.NumberLiteral");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_20=(Token)match(input,30,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getObjectLiteralAccess().getCommaKeyword_3_4());
                      			
                    }
                    // InternalFLY.g:2874:4: ( (lv_range2_21_0= ruleRangeLiteral ) )
                    // InternalFLY.g:2875:5: (lv_range2_21_0= ruleRangeLiteral )
                    {
                    // InternalFLY.g:2875:5: (lv_range2_21_0= ruleRangeLiteral )
                    // InternalFLY.g:2876:6: lv_range2_21_0= ruleRangeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getObjectLiteralAccess().getRange2RangeLiteralParserRuleCall_3_5_0());
                      					
                    }
                    pushFollow(FOLLOW_30);
                    lv_range2_21_0=ruleRangeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getObjectLiteralRule());
                      						}
                      						set(
                      							current,
                      							"range2",
                      							lv_range2_21_0,
                      							"org.xtext.FLY.RangeLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_22=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_22, grammarAccess.getObjectLiteralAccess().getRightSquareBracketKeyword_3_6());
                      			
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


    // $ANTLR start "entryRuleSubIndex"
    // InternalFLY.g:2902:1: entryRuleSubIndex returns [EObject current=null] : iv_ruleSubIndex= ruleSubIndex EOF ;
    public final EObject entryRuleSubIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubIndex = null;


        try {
            // InternalFLY.g:2902:49: (iv_ruleSubIndex= ruleSubIndex EOF )
            // InternalFLY.g:2903:2: iv_ruleSubIndex= ruleSubIndex EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubIndexRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSubIndex=ruleSubIndex();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubIndex; 
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
    // $ANTLR end "entryRuleSubIndex"


    // $ANTLR start "ruleSubIndex"
    // InternalFLY.g:2909:1: ruleSubIndex returns [EObject current=null] : (otherlv_0= '[' ( (lv_value_1_0= ruleArithmeticExpression ) ) (otherlv_2= ':' ( (lv_value2_3_0= ruleArithmeticExpression ) ) )? otherlv_4= ']' ) ;
    public final EObject ruleSubIndex() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_value_1_0 = null;

        EObject lv_value2_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:2915:2: ( (otherlv_0= '[' ( (lv_value_1_0= ruleArithmeticExpression ) ) (otherlv_2= ':' ( (lv_value2_3_0= ruleArithmeticExpression ) ) )? otherlv_4= ']' ) )
            // InternalFLY.g:2916:2: (otherlv_0= '[' ( (lv_value_1_0= ruleArithmeticExpression ) ) (otherlv_2= ':' ( (lv_value2_3_0= ruleArithmeticExpression ) ) )? otherlv_4= ']' )
            {
            // InternalFLY.g:2916:2: (otherlv_0= '[' ( (lv_value_1_0= ruleArithmeticExpression ) ) (otherlv_2= ':' ( (lv_value2_3_0= ruleArithmeticExpression ) ) )? otherlv_4= ']' )
            // InternalFLY.g:2917:3: otherlv_0= '[' ( (lv_value_1_0= ruleArithmeticExpression ) ) (otherlv_2= ':' ( (lv_value2_3_0= ruleArithmeticExpression ) ) )? otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSubIndexAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalFLY.g:2921:3: ( (lv_value_1_0= ruleArithmeticExpression ) )
            // InternalFLY.g:2922:4: (lv_value_1_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:2922:4: (lv_value_1_0= ruleArithmeticExpression )
            // InternalFLY.g:2923:5: lv_value_1_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSubIndexAccess().getValueArithmeticExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_36);
            lv_value_1_0=ruleArithmeticExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSubIndexRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.xtext.FLY.ArithmeticExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalFLY.g:2940:3: (otherlv_2= ':' ( (lv_value2_3_0= ruleArithmeticExpression ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==45) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalFLY.g:2941:4: otherlv_2= ':' ( (lv_value2_3_0= ruleArithmeticExpression ) )
                    {
                    otherlv_2=(Token)match(input,45,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSubIndexAccess().getColonKeyword_2_0());
                      			
                    }
                    // InternalFLY.g:2945:4: ( (lv_value2_3_0= ruleArithmeticExpression ) )
                    // InternalFLY.g:2946:5: (lv_value2_3_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:2946:5: (lv_value2_3_0= ruleArithmeticExpression )
                    // InternalFLY.g:2947:6: lv_value2_3_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSubIndexAccess().getValue2ArithmeticExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_30);
                    lv_value2_3_0=ruleArithmeticExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSubIndexRule());
                      						}
                      						set(
                      							current,
                      							"value2",
                      							lv_value2_3_0,
                      							"org.xtext.FLY.ArithmeticExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSubIndexAccess().getRightSquareBracketKeyword_3());
              		
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
    // $ANTLR end "ruleSubIndex"


    // $ANTLR start "entryRuleRangeLiteral"
    // InternalFLY.g:2973:1: entryRuleRangeLiteral returns [EObject current=null] : iv_ruleRangeLiteral= ruleRangeLiteral EOF ;
    public final EObject entryRuleRangeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeLiteral = null;


        try {
            // InternalFLY.g:2973:53: (iv_ruleRangeLiteral= ruleRangeLiteral EOF )
            // InternalFLY.g:2974:2: iv_ruleRangeLiteral= ruleRangeLiteral EOF
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
    // InternalFLY.g:2980:1: ruleRangeLiteral returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_value1_2_0= RULE_INT ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ':' ( ( (lv_value2_5_0= RULE_INT ) ) | ( (otherlv_6= RULE_ID ) ) ) otherlv_7= ']' ) ;
    public final EObject ruleRangeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_value1_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_value2_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalFLY.g:2986:2: ( ( () otherlv_1= '[' ( ( (lv_value1_2_0= RULE_INT ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ':' ( ( (lv_value2_5_0= RULE_INT ) ) | ( (otherlv_6= RULE_ID ) ) ) otherlv_7= ']' ) )
            // InternalFLY.g:2987:2: ( () otherlv_1= '[' ( ( (lv_value1_2_0= RULE_INT ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ':' ( ( (lv_value2_5_0= RULE_INT ) ) | ( (otherlv_6= RULE_ID ) ) ) otherlv_7= ']' )
            {
            // InternalFLY.g:2987:2: ( () otherlv_1= '[' ( ( (lv_value1_2_0= RULE_INT ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ':' ( ( (lv_value2_5_0= RULE_INT ) ) | ( (otherlv_6= RULE_ID ) ) ) otherlv_7= ']' )
            // InternalFLY.g:2988:3: () otherlv_1= '[' ( ( (lv_value1_2_0= RULE_INT ) ) | ( (otherlv_3= RULE_ID ) ) ) otherlv_4= ':' ( ( (lv_value2_5_0= RULE_INT ) ) | ( (otherlv_6= RULE_ID ) ) ) otherlv_7= ']'
            {
            // InternalFLY.g:2988:3: ()
            // InternalFLY.g:2989:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRangeLiteralAccess().getRangeLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,42,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRangeLiteralAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalFLY.g:2999:3: ( ( (lv_value1_2_0= RULE_INT ) ) | ( (otherlv_3= RULE_ID ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_INT) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_ID) ) {
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
                    // InternalFLY.g:3000:4: ( (lv_value1_2_0= RULE_INT ) )
                    {
                    // InternalFLY.g:3000:4: ( (lv_value1_2_0= RULE_INT ) )
                    // InternalFLY.g:3001:5: (lv_value1_2_0= RULE_INT )
                    {
                    // InternalFLY.g:3001:5: (lv_value1_2_0= RULE_INT )
                    // InternalFLY.g:3002:6: lv_value1_2_0= RULE_INT
                    {
                    lv_value1_2_0=(Token)match(input,RULE_INT,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value1_2_0, grammarAccess.getRangeLiteralAccess().getValue1INTTerminalRuleCall_2_0_0());
                      					
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


                    }
                    break;
                case 2 :
                    // InternalFLY.g:3019:4: ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalFLY.g:3019:4: ( (otherlv_3= RULE_ID ) )
                    // InternalFLY.g:3020:5: (otherlv_3= RULE_ID )
                    {
                    // InternalFLY.g:3020:5: (otherlv_3= RULE_ID )
                    // InternalFLY.g:3021:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRangeLiteralRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getRangeLiteralAccess().getValue_l1VariableDeclarationCrossReference_2_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,45,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getRangeLiteralAccess().getColonKeyword_3());
              		
            }
            // InternalFLY.g:3037:3: ( ( (lv_value2_5_0= RULE_INT ) ) | ( (otherlv_6= RULE_ID ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_INT) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_ID) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalFLY.g:3038:4: ( (lv_value2_5_0= RULE_INT ) )
                    {
                    // InternalFLY.g:3038:4: ( (lv_value2_5_0= RULE_INT ) )
                    // InternalFLY.g:3039:5: (lv_value2_5_0= RULE_INT )
                    {
                    // InternalFLY.g:3039:5: (lv_value2_5_0= RULE_INT )
                    // InternalFLY.g:3040:6: lv_value2_5_0= RULE_INT
                    {
                    lv_value2_5_0=(Token)match(input,RULE_INT,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value2_5_0, grammarAccess.getRangeLiteralAccess().getValue2INTTerminalRuleCall_4_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRangeLiteralRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value2",
                      							lv_value2_5_0,
                      							"org.eclipse.xtext.common.Terminals.INT");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFLY.g:3057:4: ( (otherlv_6= RULE_ID ) )
                    {
                    // InternalFLY.g:3057:4: ( (otherlv_6= RULE_ID ) )
                    // InternalFLY.g:3058:5: (otherlv_6= RULE_ID )
                    {
                    // InternalFLY.g:3058:5: (otherlv_6= RULE_ID )
                    // InternalFLY.g:3059:6: otherlv_6= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRangeLiteralRule());
                      						}
                      					
                    }
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_6, grammarAccess.getRangeLiteralAccess().getValue_l2VariableDeclarationCrossReference_4_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getRangeLiteralAccess().getRightSquareBracketKeyword_5());
              		
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
    // InternalFLY.g:3079:1: entryRuleMathFunction returns [EObject current=null] : iv_ruleMathFunction= ruleMathFunction EOF ;
    public final EObject entryRuleMathFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathFunction = null;


        try {
            // InternalFLY.g:3079:53: (iv_ruleMathFunction= ruleMathFunction EOF )
            // InternalFLY.g:3080:2: iv_ruleMathFunction= ruleMathFunction EOF
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
    // InternalFLY.g:3086:1: ruleMathFunction returns [EObject current=null] : ( () otherlv_1= 'Math' otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' ) ;
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
            // InternalFLY.g:3092:2: ( ( () otherlv_1= 'Math' otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' ) )
            // InternalFLY.g:3093:2: ( () otherlv_1= 'Math' otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' )
            {
            // InternalFLY.g:3093:2: ( () otherlv_1= 'Math' otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' )
            // InternalFLY.g:3094:3: () otherlv_1= 'Math' otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')'
            {
            // InternalFLY.g:3094:3: ()
            // InternalFLY.g:3095:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMathFunctionAccess().getMathFunctionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,46,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMathFunctionAccess().getMathKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,44,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getMathFunctionAccess().getFullStopKeyword_2());
              		
            }
            // InternalFLY.g:3109:3: ( (lv_feature_3_0= RULE_ID ) )
            // InternalFLY.g:3110:4: (lv_feature_3_0= RULE_ID )
            {
            // InternalFLY.g:3110:4: (lv_feature_3_0= RULE_ID )
            // InternalFLY.g:3111:5: lv_feature_3_0= RULE_ID
            {
            lv_feature_3_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,21,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getMathFunctionAccess().getLeftParenthesisKeyword_4());
              		
            }
            // InternalFLY.g:3131:3: ( (lv_expressions_5_0= ruleArithmeticExpression ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_ID && LA36_0<=RULE_INT)||LA36_0==RULE_FLOAT||LA36_0==21||LA36_0==42||LA36_0==46||(LA36_0>=67 && LA36_0<=68)||LA36_0==71||(LA36_0>=80 && LA36_0<=82)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalFLY.g:3132:4: (lv_expressions_5_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:3132:4: (lv_expressions_5_0= ruleArithmeticExpression )
                    // InternalFLY.g:3133:5: lv_expressions_5_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getMathFunctionAccess().getExpressionsArithmeticExpressionParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_40);
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

            // InternalFLY.g:3150:3: (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==30) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalFLY.g:3151:4: otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) )
            	    {
            	    otherlv_6=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getMathFunctionAccess().getCommaKeyword_6_0());
            	      			
            	    }
            	    // InternalFLY.g:3155:4: ( (lv_expressions_7_0= ruleArithmeticExpression ) )
            	    // InternalFLY.g:3156:5: (lv_expressions_7_0= ruleArithmeticExpression )
            	    {
            	    // InternalFLY.g:3156:5: (lv_expressions_7_0= ruleArithmeticExpression )
            	    // InternalFLY.g:3157:6: lv_expressions_7_0= ruleArithmeticExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMathFunctionAccess().getExpressionsArithmeticExpressionParserRuleCall_6_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop37;
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
    // InternalFLY.g:3183:1: entryRuleVariableFunction returns [EObject current=null] : iv_ruleVariableFunction= ruleVariableFunction EOF ;
    public final EObject entryRuleVariableFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableFunction = null;


        try {
            // InternalFLY.g:3183:57: (iv_ruleVariableFunction= ruleVariableFunction EOF )
            // InternalFLY.g:3184:2: iv_ruleVariableFunction= ruleVariableFunction EOF
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
    // InternalFLY.g:3190:1: ruleVariableFunction returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' ) ;
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
            // InternalFLY.g:3196:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' ) )
            // InternalFLY.g:3197:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' )
            {
            // InternalFLY.g:3197:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')' )
            // InternalFLY.g:3198:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_expressions_5_0= ruleArithmeticExpression ) )? (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )* otherlv_8= ')'
            {
            // InternalFLY.g:3198:3: ()
            // InternalFLY.g:3199:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableFunctionAccess().getVariableFunctionAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:3205:3: ( (otherlv_1= RULE_ID ) )
            // InternalFLY.g:3206:4: (otherlv_1= RULE_ID )
            {
            // InternalFLY.g:3206:4: (otherlv_1= RULE_ID )
            // InternalFLY.g:3207:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableFunctionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getVariableFunctionAccess().getTargetVariableDeclarationCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,44,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getVariableFunctionAccess().getFullStopKeyword_2());
              		
            }
            // InternalFLY.g:3222:3: ( (lv_feature_3_0= RULE_ID ) )
            // InternalFLY.g:3223:4: (lv_feature_3_0= RULE_ID )
            {
            // InternalFLY.g:3223:4: (lv_feature_3_0= RULE_ID )
            // InternalFLY.g:3224:5: lv_feature_3_0= RULE_ID
            {
            lv_feature_3_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,21,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getVariableFunctionAccess().getLeftParenthesisKeyword_4());
              		
            }
            // InternalFLY.g:3244:3: ( (lv_expressions_5_0= ruleArithmeticExpression ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_INT)||LA38_0==RULE_FLOAT||LA38_0==21||LA38_0==42||LA38_0==46||(LA38_0>=67 && LA38_0<=68)||LA38_0==71||(LA38_0>=80 && LA38_0<=82)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalFLY.g:3245:4: (lv_expressions_5_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:3245:4: (lv_expressions_5_0= ruleArithmeticExpression )
                    // InternalFLY.g:3246:5: lv_expressions_5_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVariableFunctionAccess().getExpressionsArithmeticExpressionParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_40);
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

            // InternalFLY.g:3263:3: (otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==30) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalFLY.g:3264:4: otherlv_6= ',' ( (lv_expressions_7_0= ruleArithmeticExpression ) )
            	    {
            	    otherlv_6=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getVariableFunctionAccess().getCommaKeyword_6_0());
            	      			
            	    }
            	    // InternalFLY.g:3268:4: ( (lv_expressions_7_0= ruleArithmeticExpression ) )
            	    // InternalFLY.g:3269:5: (lv_expressions_7_0= ruleArithmeticExpression )
            	    {
            	    // InternalFLY.g:3269:5: (lv_expressions_7_0= ruleArithmeticExpression )
            	    // InternalFLY.g:3270:6: lv_expressions_7_0= ruleArithmeticExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getVariableFunctionAccess().getExpressionsArithmeticExpressionParserRuleCall_6_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop39;
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
    // InternalFLY.g:3296:1: entryRuleFunctionReturn returns [EObject current=null] : iv_ruleFunctionReturn= ruleFunctionReturn EOF ;
    public final EObject entryRuleFunctionReturn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionReturn = null;


        try {
            // InternalFLY.g:3296:55: (iv_ruleFunctionReturn= ruleFunctionReturn EOF )
            // InternalFLY.g:3297:2: iv_ruleFunctionReturn= ruleFunctionReturn EOF
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
    // InternalFLY.g:3303:1: ruleFunctionReturn returns [EObject current=null] : ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleArithmeticExpression ) ) ) ;
    public final EObject ruleFunctionReturn() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3309:2: ( ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleArithmeticExpression ) ) ) )
            // InternalFLY.g:3310:2: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleArithmeticExpression ) ) )
            {
            // InternalFLY.g:3310:2: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleArithmeticExpression ) ) )
            // InternalFLY.g:3311:3: () otherlv_1= 'return' ( (lv_expression_2_0= ruleArithmeticExpression ) )
            {
            // InternalFLY.g:3311:3: ()
            // InternalFLY.g:3312:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFunctionReturnAccess().getFunctionReturnAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,47,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionReturnAccess().getReturnKeyword_1());
              		
            }
            // InternalFLY.g:3322:3: ( (lv_expression_2_0= ruleArithmeticExpression ) )
            // InternalFLY.g:3323:4: (lv_expression_2_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:3323:4: (lv_expression_2_0= ruleArithmeticExpression )
            // InternalFLY.g:3324:5: lv_expression_2_0= ruleArithmeticExpression
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
    // InternalFLY.g:3345:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalFLY.g:3345:59: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalFLY.g:3346:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
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
    // InternalFLY.g:3352:1: ruleFunctionDefinition returns [EObject current=null] : ( () otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParams ) )? (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )* otherlv_7= ')' ( (lv_body_8_0= ruleBlockExpression ) ) ) ;
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
            // InternalFLY.g:3358:2: ( ( () otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParams ) )? (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )* otherlv_7= ')' ( (lv_body_8_0= ruleBlockExpression ) ) ) )
            // InternalFLY.g:3359:2: ( () otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParams ) )? (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )* otherlv_7= ')' ( (lv_body_8_0= ruleBlockExpression ) ) )
            {
            // InternalFLY.g:3359:2: ( () otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParams ) )? (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )* otherlv_7= ')' ( (lv_body_8_0= ruleBlockExpression ) ) )
            // InternalFLY.g:3360:3: () otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParams ) )? (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )* otherlv_7= ')' ( (lv_body_8_0= ruleBlockExpression ) )
            {
            // InternalFLY.g:3360:3: ()
            // InternalFLY.g:3361:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFunctionDefinitionAccess().getFunctionDefinitionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,48,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getFuncKeyword_1());
              		
            }
            // InternalFLY.g:3371:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalFLY.g:3372:4: (lv_name_2_0= RULE_ID )
            {
            // InternalFLY.g:3372:4: (lv_name_2_0= RULE_ID )
            // InternalFLY.g:3373:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,21,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalFLY.g:3393:3: ( (lv_parameters_4_0= ruleParams ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalFLY.g:3394:4: (lv_parameters_4_0= ruleParams )
                    {
                    // InternalFLY.g:3394:4: (lv_parameters_4_0= ruleParams )
                    // InternalFLY.g:3395:5: lv_parameters_4_0= ruleParams
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParamsParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_40);
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

            // InternalFLY.g:3412:3: (otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==30) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalFLY.g:3413:4: otherlv_5= ',' ( (lv_parameters_6_0= ruleParams ) )
            	    {
            	    otherlv_5=(Token)match(input,30,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_5_0());
            	      			
            	    }
            	    // InternalFLY.g:3417:4: ( (lv_parameters_6_0= ruleParams ) )
            	    // InternalFLY.g:3418:5: (lv_parameters_6_0= ruleParams )
            	    {
            	    // InternalFLY.g:3418:5: (lv_parameters_6_0= ruleParams )
            	    // InternalFLY.g:3419:6: lv_parameters_6_0= ruleParams
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParamsParserRuleCall_5_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop41;
                }
            } while (true);

            otherlv_7=(Token)match(input,22,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalFLY.g:3441:3: ( (lv_body_8_0= ruleBlockExpression ) )
            // InternalFLY.g:3442:4: (lv_body_8_0= ruleBlockExpression )
            {
            // InternalFLY.g:3442:4: (lv_body_8_0= ruleBlockExpression )
            // InternalFLY.g:3443:5: lv_body_8_0= ruleBlockExpression
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
    // InternalFLY.g:3464:1: entryRuleParams returns [EObject current=null] : iv_ruleParams= ruleParams EOF ;
    public final EObject entryRuleParams() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParams = null;


        try {
            // InternalFLY.g:3464:47: (iv_ruleParams= ruleParams EOF )
            // InternalFLY.g:3465:2: iv_ruleParams= ruleParams EOF
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
    // InternalFLY.g:3471:1: ruleParams returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParams() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFLY.g:3477:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFLY.g:3478:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFLY.g:3478:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFLY.g:3479:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalFLY.g:3479:3: ()
            // InternalFLY.g:3480:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParamsAccess().getVariableDeclarationAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:3486:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFLY.g:3487:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFLY.g:3487:4: (lv_name_1_0= RULE_ID )
            // InternalFLY.g:3488:5: lv_name_1_0= RULE_ID
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
    // InternalFLY.g:3508:1: entryRuleChannelSend returns [EObject current=null] : iv_ruleChannelSend= ruleChannelSend EOF ;
    public final EObject entryRuleChannelSend() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChannelSend = null;


        try {
            // InternalFLY.g:3508:52: (iv_ruleChannelSend= ruleChannelSend EOF )
            // InternalFLY.g:3509:2: iv_ruleChannelSend= ruleChannelSend EOF
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
    // InternalFLY.g:3515:1: ruleChannelSend returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '!' ( (lv_expression_3_0= ruleArithmeticExpression ) ) ) ;
    public final EObject ruleChannelSend() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3521:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '!' ( (lv_expression_3_0= ruleArithmeticExpression ) ) ) )
            // InternalFLY.g:3522:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '!' ( (lv_expression_3_0= ruleArithmeticExpression ) ) )
            {
            // InternalFLY.g:3522:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '!' ( (lv_expression_3_0= ruleArithmeticExpression ) ) )
            // InternalFLY.g:3523:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '!' ( (lv_expression_3_0= ruleArithmeticExpression ) )
            {
            // InternalFLY.g:3523:3: ()
            // InternalFLY.g:3524:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getChannelSendAccess().getChannelSendAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:3530:3: ( (otherlv_1= RULE_ID ) )
            // InternalFLY.g:3531:4: (otherlv_1= RULE_ID )
            {
            // InternalFLY.g:3531:4: (otherlv_1= RULE_ID )
            // InternalFLY.g:3532:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getChannelSendRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getChannelSendAccess().getTargetChannelDeclarationCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,49,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getChannelSendAccess().getExclamationMarkKeyword_2());
              		
            }
            // InternalFLY.g:3547:3: ( (lv_expression_3_0= ruleArithmeticExpression ) )
            // InternalFLY.g:3548:4: (lv_expression_3_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:3548:4: (lv_expression_3_0= ruleArithmeticExpression )
            // InternalFLY.g:3549:5: lv_expression_3_0= ruleArithmeticExpression
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
    // InternalFLY.g:3570:1: entryRuleChannelReceive returns [EObject current=null] : iv_ruleChannelReceive= ruleChannelReceive EOF ;
    public final EObject entryRuleChannelReceive() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChannelReceive = null;


        try {
            // InternalFLY.g:3570:55: (iv_ruleChannelReceive= ruleChannelReceive EOF )
            // InternalFLY.g:3571:2: iv_ruleChannelReceive= ruleChannelReceive EOF
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
    // InternalFLY.g:3577:1: ruleChannelReceive returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '?' ) ;
    public final EObject ruleChannelReceive() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalFLY.g:3583:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '?' ) )
            // InternalFLY.g:3584:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '?' )
            {
            // InternalFLY.g:3584:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '?' )
            // InternalFLY.g:3585:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '?'
            {
            // InternalFLY.g:3585:3: ()
            // InternalFLY.g:3586:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getChannelReceiveAccess().getChannelReceiveAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:3592:3: ( (otherlv_1= RULE_ID ) )
            // InternalFLY.g:3593:4: (otherlv_1= RULE_ID )
            {
            // InternalFLY.g:3593:4: (otherlv_1= RULE_ID )
            // InternalFLY.g:3594:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getChannelReceiveRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getChannelReceiveAccess().getTargetChannelDeclarationCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
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
    // InternalFLY.g:3613:1: entryRuleLocalFunctionCall returns [EObject current=null] : iv_ruleLocalFunctionCall= ruleLocalFunctionCall EOF ;
    public final EObject entryRuleLocalFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalFunctionCall = null;


        try {
            // InternalFLY.g:3613:58: (iv_ruleLocalFunctionCall= ruleLocalFunctionCall EOF )
            // InternalFLY.g:3614:2: iv_ruleLocalFunctionCall= ruleLocalFunctionCall EOF
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
    // InternalFLY.g:3620:1: ruleLocalFunctionCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_input_3_0= ruleLocalFunctionInput ) ) otherlv_4= ')' ) ;
    public final EObject ruleLocalFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_input_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3626:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_input_3_0= ruleLocalFunctionInput ) ) otherlv_4= ')' ) )
            // InternalFLY.g:3627:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_input_3_0= ruleLocalFunctionInput ) ) otherlv_4= ')' )
            {
            // InternalFLY.g:3627:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_input_3_0= ruleLocalFunctionInput ) ) otherlv_4= ')' )
            // InternalFLY.g:3628:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_input_3_0= ruleLocalFunctionInput ) ) otherlv_4= ')'
            {
            // InternalFLY.g:3628:3: ()
            // InternalFLY.g:3629:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLocalFunctionCallAccess().getLocalFunctionCallAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:3635:3: ( (otherlv_1= RULE_ID ) )
            // InternalFLY.g:3636:4: (otherlv_1= RULE_ID )
            {
            // InternalFLY.g:3636:4: (otherlv_1= RULE_ID )
            // InternalFLY.g:3637:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLocalFunctionCallRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getLocalFunctionCallAccess().getTargetFunctionDefinitionCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLocalFunctionCallAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalFLY.g:3652:3: ( (lv_input_3_0= ruleLocalFunctionInput ) )
            // InternalFLY.g:3653:4: (lv_input_3_0= ruleLocalFunctionInput )
            {
            // InternalFLY.g:3653:4: (lv_input_3_0= ruleLocalFunctionInput )
            // InternalFLY.g:3654:5: lv_input_3_0= ruleLocalFunctionInput
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLocalFunctionCallAccess().getInputLocalFunctionInputParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_10);
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
    // InternalFLY.g:3679:1: entryRuleLocalFunctionInput returns [EObject current=null] : iv_ruleLocalFunctionInput= ruleLocalFunctionInput EOF ;
    public final EObject entryRuleLocalFunctionInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalFunctionInput = null;


        try {
            // InternalFLY.g:3679:59: (iv_ruleLocalFunctionInput= ruleLocalFunctionInput EOF )
            // InternalFLY.g:3680:2: iv_ruleLocalFunctionInput= ruleLocalFunctionInput EOF
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
    // InternalFLY.g:3686:1: ruleLocalFunctionInput returns [EObject current=null] : ( () ( (lv_inputs_1_0= ruleArithmeticExpression ) )? (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )* ) ;
    public final EObject ruleLocalFunctionInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_inputs_1_0 = null;

        EObject lv_inputs_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:3692:2: ( ( () ( (lv_inputs_1_0= ruleArithmeticExpression ) )? (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )* ) )
            // InternalFLY.g:3693:2: ( () ( (lv_inputs_1_0= ruleArithmeticExpression ) )? (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )* )
            {
            // InternalFLY.g:3693:2: ( () ( (lv_inputs_1_0= ruleArithmeticExpression ) )? (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )* )
            // InternalFLY.g:3694:3: () ( (lv_inputs_1_0= ruleArithmeticExpression ) )? (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )*
            {
            // InternalFLY.g:3694:3: ()
            // InternalFLY.g:3695:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLocalFunctionInputAccess().getLocalFunctionInputAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:3701:3: ( (lv_inputs_1_0= ruleArithmeticExpression ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_ID && LA42_0<=RULE_INT)||LA42_0==RULE_FLOAT||LA42_0==21||LA42_0==42||LA42_0==46||(LA42_0>=67 && LA42_0<=68)||LA42_0==71||(LA42_0>=80 && LA42_0<=82)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalFLY.g:3702:4: (lv_inputs_1_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:3702:4: (lv_inputs_1_0= ruleArithmeticExpression )
                    // InternalFLY.g:3703:5: lv_inputs_1_0= ruleArithmeticExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLocalFunctionInputAccess().getInputsArithmeticExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_18);
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

            // InternalFLY.g:3720:3: (otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==30) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalFLY.g:3721:4: otherlv_2= ',' ( (lv_inputs_3_0= ruleArithmeticExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLocalFunctionInputAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalFLY.g:3725:4: ( (lv_inputs_3_0= ruleArithmeticExpression ) )
            	    // InternalFLY.g:3726:5: (lv_inputs_3_0= ruleArithmeticExpression )
            	    {
            	    // InternalFLY.g:3726:5: (lv_inputs_3_0= ruleArithmeticExpression )
            	    // InternalFLY.g:3727:6: lv_inputs_3_0= ruleArithmeticExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLocalFunctionInputAccess().getInputsArithmeticExpressionParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
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
    // $ANTLR end "ruleLocalFunctionInput"


    // $ANTLR start "entryRuleFlyFunctionCall"
    // InternalFLY.g:3749:1: entryRuleFlyFunctionCall returns [EObject current=null] : iv_ruleFlyFunctionCall= ruleFlyFunctionCall EOF ;
    public final EObject entryRuleFlyFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlyFunctionCall = null;


        try {
            // InternalFLY.g:3749:56: (iv_ruleFlyFunctionCall= ruleFlyFunctionCall EOF )
            // InternalFLY.g:3750:2: iv_ruleFlyFunctionCall= ruleFlyFunctionCall EOF
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
    // InternalFLY.g:3756:1: ruleFlyFunctionCall returns [EObject current=null] : ( () ( (lv_isAsync_1_0= 'async' ) )? otherlv_2= 'fly' ( (otherlv_3= RULE_ID ) ) ( (lv_input_4_0= ruleFunctionInput ) )? otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )? ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )? ) ;
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
            // InternalFLY.g:3762:2: ( ( () ( (lv_isAsync_1_0= 'async' ) )? otherlv_2= 'fly' ( (otherlv_3= RULE_ID ) ) ( (lv_input_4_0= ruleFunctionInput ) )? otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )? ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )? ) )
            // InternalFLY.g:3763:2: ( () ( (lv_isAsync_1_0= 'async' ) )? otherlv_2= 'fly' ( (otherlv_3= RULE_ID ) ) ( (lv_input_4_0= ruleFunctionInput ) )? otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )? ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )? )
            {
            // InternalFLY.g:3763:2: ( () ( (lv_isAsync_1_0= 'async' ) )? otherlv_2= 'fly' ( (otherlv_3= RULE_ID ) ) ( (lv_input_4_0= ruleFunctionInput ) )? otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )? ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )? )
            // InternalFLY.g:3764:3: () ( (lv_isAsync_1_0= 'async' ) )? otherlv_2= 'fly' ( (otherlv_3= RULE_ID ) ) ( (lv_input_4_0= ruleFunctionInput ) )? otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )? ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )?
            {
            // InternalFLY.g:3764:3: ()
            // InternalFLY.g:3765:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFlyFunctionCallAccess().getFlyFunctionCallAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:3771:3: ( (lv_isAsync_1_0= 'async' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==51) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalFLY.g:3772:4: (lv_isAsync_1_0= 'async' )
                    {
                    // InternalFLY.g:3772:4: (lv_isAsync_1_0= 'async' )
                    // InternalFLY.g:3773:5: lv_isAsync_1_0= 'async'
                    {
                    lv_isAsync_1_0=(Token)match(input,51,FOLLOW_45); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,52,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFlyFunctionCallAccess().getFlyKeyword_2());
              		
            }
            // InternalFLY.g:3789:3: ( (otherlv_3= RULE_ID ) )
            // InternalFLY.g:3790:4: (otherlv_3= RULE_ID )
            {
            // InternalFLY.g:3790:4: (otherlv_3= RULE_ID )
            // InternalFLY.g:3791:5: otherlv_3= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFlyFunctionCallRule());
              					}
              				
            }
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_3, grammarAccess.getFlyFunctionCallAccess().getTargetFunctionDefinitionCrossReference_3_0());
              				
            }

            }


            }

            // InternalFLY.g:3802:3: ( (lv_input_4_0= ruleFunctionInput ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==21||LA45_0==25) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalFLY.g:3803:4: (lv_input_4_0= ruleFunctionInput )
                    {
                    // InternalFLY.g:3803:4: (lv_input_4_0= ruleFunctionInput )
                    // InternalFLY.g:3804:5: lv_input_4_0= ruleFunctionInput
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFlyFunctionCallAccess().getInputFunctionInputParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_6);
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

            otherlv_5=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFlyFunctionCallAccess().getOnKeyword_5());
              		
            }
            // InternalFLY.g:3825:3: ( (otherlv_6= RULE_ID ) )
            // InternalFLY.g:3826:4: (otherlv_6= RULE_ID )
            {
            // InternalFLY.g:3826:4: (otherlv_6= RULE_ID )
            // InternalFLY.g:3827:5: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFlyFunctionCallRule());
              					}
              				
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_6, grammarAccess.getFlyFunctionCallAccess().getEnvironmentEnvironmentDeclarationCrossReference_6_0());
              				
            }

            }


            }

            // InternalFLY.g:3838:3: ( ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==53) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalFLY.g:3839:4: ( (lv_is_then_7_0= 'then' ) ) ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalFLY.g:3839:4: ( (lv_is_then_7_0= 'then' ) )
                    // InternalFLY.g:3840:5: (lv_is_then_7_0= 'then' )
                    {
                    // InternalFLY.g:3840:5: (lv_is_then_7_0= 'then' )
                    // InternalFLY.g:3841:6: lv_is_then_7_0= 'then'
                    {
                    lv_is_then_7_0=(Token)match(input,53,FOLLOW_5); if (state.failed) return current;
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

                    // InternalFLY.g:3853:4: ( (otherlv_8= RULE_ID ) )
                    // InternalFLY.g:3854:5: (otherlv_8= RULE_ID )
                    {
                    // InternalFLY.g:3854:5: (otherlv_8= RULE_ID )
                    // InternalFLY.g:3855:6: otherlv_8= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFlyFunctionCallRule());
                      						}
                      					
                    }
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_8, grammarAccess.getFlyFunctionCallAccess().getThenFunctionDefinitionCrossReference_7_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalFLY.g:3867:3: ( ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==54) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalFLY.g:3868:4: ( (lv_is_thenall_9_0= 'thenall' ) ) ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalFLY.g:3868:4: ( (lv_is_thenall_9_0= 'thenall' ) )
                    // InternalFLY.g:3869:5: (lv_is_thenall_9_0= 'thenall' )
                    {
                    // InternalFLY.g:3869:5: (lv_is_thenall_9_0= 'thenall' )
                    // InternalFLY.g:3870:6: lv_is_thenall_9_0= 'thenall'
                    {
                    lv_is_thenall_9_0=(Token)match(input,54,FOLLOW_5); if (state.failed) return current;
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

                    // InternalFLY.g:3882:4: ( (otherlv_10= RULE_ID ) )
                    // InternalFLY.g:3883:5: (otherlv_10= RULE_ID )
                    {
                    // InternalFLY.g:3883:5: (otherlv_10= RULE_ID )
                    // InternalFLY.g:3884:6: otherlv_10= RULE_ID
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
    // InternalFLY.g:3900:1: entryRuleFunctionInput returns [EObject current=null] : iv_ruleFunctionInput= ruleFunctionInput EOF ;
    public final EObject entryRuleFunctionInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionInput = null;


        try {
            // InternalFLY.g:3900:54: (iv_ruleFunctionInput= ruleFunctionInput EOF )
            // InternalFLY.g:3901:2: iv_ruleFunctionInput= ruleFunctionInput EOF
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
    // InternalFLY.g:3907:1: ruleFunctionInput returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' ) | ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) ) ) ;
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
            // InternalFLY.g:3913:2: ( ( ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' ) | ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) ) ) )
            // InternalFLY.g:3914:2: ( ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' ) | ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) ) )
            {
            // InternalFLY.g:3914:2: ( ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' ) | ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==21) ) {
                alt50=1;
            }
            else if ( (LA50_0==25) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalFLY.g:3915:3: ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' )
                    {
                    // InternalFLY.g:3915:3: ( () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')' )
                    // InternalFLY.g:3916:4: () otherlv_1= '(' ( (lv_expressions_2_0= ruleArithmeticExpression ) )? (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )* otherlv_5= ')'
                    {
                    // InternalFLY.g:3916:4: ()
                    // InternalFLY.g:3917:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getFunctionInputAccess().getFunctionInputAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getFunctionInputAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalFLY.g:3927:4: ( (lv_expressions_2_0= ruleArithmeticExpression ) )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( ((LA48_0>=RULE_ID && LA48_0<=RULE_INT)||LA48_0==RULE_FLOAT||LA48_0==21||LA48_0==42||LA48_0==46||(LA48_0>=67 && LA48_0<=68)||LA48_0==71||(LA48_0>=80 && LA48_0<=82)) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // InternalFLY.g:3928:5: (lv_expressions_2_0= ruleArithmeticExpression )
                            {
                            // InternalFLY.g:3928:5: (lv_expressions_2_0= ruleArithmeticExpression )
                            // InternalFLY.g:3929:6: lv_expressions_2_0= ruleArithmeticExpression
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getFunctionInputAccess().getExpressionsArithmeticExpressionParserRuleCall_0_2_0());
                              					
                            }
                            pushFollow(FOLLOW_40);
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

                    // InternalFLY.g:3946:4: (otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==30) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalFLY.g:3947:5: otherlv_3= ',' ( (lv_expressions_4_0= ruleArithmeticExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getFunctionInputAccess().getCommaKeyword_0_3_0());
                    	      				
                    	    }
                    	    // InternalFLY.g:3951:5: ( (lv_expressions_4_0= ruleArithmeticExpression ) )
                    	    // InternalFLY.g:3952:6: (lv_expressions_4_0= ruleArithmeticExpression )
                    	    {
                    	    // InternalFLY.g:3952:6: (lv_expressions_4_0= ruleArithmeticExpression )
                    	    // InternalFLY.g:3953:7: lv_expressions_4_0= ruleArithmeticExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionInputAccess().getExpressionsArithmeticExpressionParserRuleCall_0_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_40);
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
                    	    break loop49;
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
                    // InternalFLY.g:3977:3: ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) )
                    {
                    // InternalFLY.g:3977:3: ( () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) ) )
                    // InternalFLY.g:3978:4: () ( (lv_is_for_index_7_0= 'in' ) ) ( (lv_f_index_8_0= ruleArithmeticExpression ) )
                    {
                    // InternalFLY.g:3978:4: ()
                    // InternalFLY.g:3979:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getFunctionInputAccess().getFunctionInputAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:3985:4: ( (lv_is_for_index_7_0= 'in' ) )
                    // InternalFLY.g:3986:5: (lv_is_for_index_7_0= 'in' )
                    {
                    // InternalFLY.g:3986:5: (lv_is_for_index_7_0= 'in' )
                    // InternalFLY.g:3987:6: lv_is_for_index_7_0= 'in'
                    {
                    lv_is_for_index_7_0=(Token)match(input,25,FOLLOW_8); if (state.failed) return current;
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

                    // InternalFLY.g:3999:4: ( (lv_f_index_8_0= ruleArithmeticExpression ) )
                    // InternalFLY.g:4000:5: (lv_f_index_8_0= ruleArithmeticExpression )
                    {
                    // InternalFLY.g:4000:5: (lv_f_index_8_0= ruleArithmeticExpression )
                    // InternalFLY.g:4001:6: lv_f_index_8_0= ruleArithmeticExpression
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


    // $ANTLR start "entryRuleNativeExpression"
    // InternalFLY.g:4023:1: entryRuleNativeExpression returns [EObject current=null] : iv_ruleNativeExpression= ruleNativeExpression EOF ;
    public final EObject entryRuleNativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNativeExpression = null;


        try {
            // InternalFLY.g:4023:57: (iv_ruleNativeExpression= ruleNativeExpression EOF )
            // InternalFLY.g:4024:2: iv_ruleNativeExpression= ruleNativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNativeExpression=ruleNativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNativeExpression; 
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
    // $ANTLR end "entryRuleNativeExpression"


    // $ANTLR start "ruleNativeExpression"
    // InternalFLY.g:4030:1: ruleNativeExpression returns [EObject current=null] : ( () otherlv_1= 'native' ( (lv_code_2_0= RULE_NATIVE_CODE ) ) ) ;
    public final EObject ruleNativeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_code_2_0=null;


        	enterRule();

        try {
            // InternalFLY.g:4036:2: ( ( () otherlv_1= 'native' ( (lv_code_2_0= RULE_NATIVE_CODE ) ) ) )
            // InternalFLY.g:4037:2: ( () otherlv_1= 'native' ( (lv_code_2_0= RULE_NATIVE_CODE ) ) )
            {
            // InternalFLY.g:4037:2: ( () otherlv_1= 'native' ( (lv_code_2_0= RULE_NATIVE_CODE ) ) )
            // InternalFLY.g:4038:3: () otherlv_1= 'native' ( (lv_code_2_0= RULE_NATIVE_CODE ) )
            {
            // InternalFLY.g:4038:3: ()
            // InternalFLY.g:4039:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getNativeExpressionAccess().getNativeExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,55,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getNativeExpressionAccess().getNativeKeyword_1());
              		
            }
            // InternalFLY.g:4049:3: ( (lv_code_2_0= RULE_NATIVE_CODE ) )
            // InternalFLY.g:4050:4: (lv_code_2_0= RULE_NATIVE_CODE )
            {
            // InternalFLY.g:4050:4: (lv_code_2_0= RULE_NATIVE_CODE )
            // InternalFLY.g:4051:5: lv_code_2_0= RULE_NATIVE_CODE
            {
            lv_code_2_0=(Token)match(input,RULE_NATIVE_CODE,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_code_2_0, grammarAccess.getNativeExpressionAccess().getCodeNATIVE_CODETerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getNativeExpressionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"code",
              						lv_code_2_0,
              						"org.xtext.FLY.NATIVE_CODE");
              				
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
    // $ANTLR end "ruleNativeExpression"


    // $ANTLR start "entryRuleRequireExpression"
    // InternalFLY.g:4071:1: entryRuleRequireExpression returns [EObject current=null] : iv_ruleRequireExpression= ruleRequireExpression EOF ;
    public final EObject entryRuleRequireExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequireExpression = null;


        try {
            // InternalFLY.g:4071:58: (iv_ruleRequireExpression= ruleRequireExpression EOF )
            // InternalFLY.g:4072:2: iv_ruleRequireExpression= ruleRequireExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRequireExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRequireExpression=ruleRequireExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRequireExpression; 
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
    // $ANTLR end "entryRuleRequireExpression"


    // $ANTLR start "ruleRequireExpression"
    // InternalFLY.g:4078:1: ruleRequireExpression returns [EObject current=null] : ( () otherlv_1= 'require' otherlv_2= '(' ( (lv_lib_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleRequireExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_lib_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalFLY.g:4084:2: ( ( () otherlv_1= 'require' otherlv_2= '(' ( (lv_lib_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) ) )
            // InternalFLY.g:4085:2: ( () otherlv_1= 'require' otherlv_2= '(' ( (lv_lib_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) )
            {
            // InternalFLY.g:4085:2: ( () otherlv_1= 'require' otherlv_2= '(' ( (lv_lib_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= 'on' ( (otherlv_6= RULE_ID ) ) )
            // InternalFLY.g:4086:3: () otherlv_1= 'require' otherlv_2= '(' ( (lv_lib_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= 'on' ( (otherlv_6= RULE_ID ) )
            {
            // InternalFLY.g:4086:3: ()
            // InternalFLY.g:4087:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRequireExpressionAccess().getRequireExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRequireExpressionAccess().getRequireKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,21,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRequireExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalFLY.g:4101:3: ( (lv_lib_3_0= RULE_STRING ) )
            // InternalFLY.g:4102:4: (lv_lib_3_0= RULE_STRING )
            {
            // InternalFLY.g:4102:4: (lv_lib_3_0= RULE_STRING )
            // InternalFLY.g:4103:5: lv_lib_3_0= RULE_STRING
            {
            lv_lib_3_0=(Token)match(input,RULE_STRING,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_lib_3_0, grammarAccess.getRequireExpressionAccess().getLibSTRINGTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRequireExpressionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"lib",
              						lv_lib_3_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getRequireExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRequireExpressionAccess().getOnKeyword_5());
              		
            }
            // InternalFLY.g:4127:3: ( (otherlv_6= RULE_ID ) )
            // InternalFLY.g:4128:4: (otherlv_6= RULE_ID )
            {
            // InternalFLY.g:4128:4: (otherlv_6= RULE_ID )
            // InternalFLY.g:4129:5: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRequireExpressionRule());
              					}
              				
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_6, grammarAccess.getRequireExpressionAccess().getEnvironmentEnvironmentDeclarationCrossReference_6_0());
              				
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
    // $ANTLR end "ruleRequireExpression"


    // $ANTLR start "entryRulePostfixOperation"
    // InternalFLY.g:4144:1: entryRulePostfixOperation returns [EObject current=null] : iv_rulePostfixOperation= rulePostfixOperation EOF ;
    public final EObject entryRulePostfixOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOperation = null;


        try {
            // InternalFLY.g:4144:57: (iv_rulePostfixOperation= rulePostfixOperation EOF )
            // InternalFLY.g:4145:2: iv_rulePostfixOperation= rulePostfixOperation EOF
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
    // InternalFLY.g:4151:1: rulePostfixOperation returns [EObject current=null] : ( ( (lv_variable_0_0= ruleVariableLiteral ) ) ( (lv_feature_1_0= ruleOpPostfix ) ) ) ;
    public final EObject rulePostfixOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_0_0 = null;

        AntlrDatatypeRuleToken lv_feature_1_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:4157:2: ( ( ( (lv_variable_0_0= ruleVariableLiteral ) ) ( (lv_feature_1_0= ruleOpPostfix ) ) ) )
            // InternalFLY.g:4158:2: ( ( (lv_variable_0_0= ruleVariableLiteral ) ) ( (lv_feature_1_0= ruleOpPostfix ) ) )
            {
            // InternalFLY.g:4158:2: ( ( (lv_variable_0_0= ruleVariableLiteral ) ) ( (lv_feature_1_0= ruleOpPostfix ) ) )
            // InternalFLY.g:4159:3: ( (lv_variable_0_0= ruleVariableLiteral ) ) ( (lv_feature_1_0= ruleOpPostfix ) )
            {
            // InternalFLY.g:4159:3: ( (lv_variable_0_0= ruleVariableLiteral ) )
            // InternalFLY.g:4160:4: (lv_variable_0_0= ruleVariableLiteral )
            {
            // InternalFLY.g:4160:4: (lv_variable_0_0= ruleVariableLiteral )
            // InternalFLY.g:4161:5: lv_variable_0_0= ruleVariableLiteral
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPostfixOperationAccess().getVariableVariableLiteralParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_50);
            lv_variable_0_0=ruleVariableLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPostfixOperationRule());
              					}
              					set(
              						current,
              						"variable",
              						lv_variable_0_0,
              						"org.xtext.FLY.VariableLiteral");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalFLY.g:4178:3: ( (lv_feature_1_0= ruleOpPostfix ) )
            // InternalFLY.g:4179:4: (lv_feature_1_0= ruleOpPostfix )
            {
            // InternalFLY.g:4179:4: (lv_feature_1_0= ruleOpPostfix )
            // InternalFLY.g:4180:5: lv_feature_1_0= ruleOpPostfix
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPostfixOperationAccess().getFeatureOpPostfixParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_feature_1_0=ruleOpPostfix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPostfixOperationRule());
              					}
              					set(
              						current,
              						"feature",
              						lv_feature_1_0,
              						"org.xtext.FLY.OpPostfix");
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
    // $ANTLR end "rulePostfixOperation"


    // $ANTLR start "entryRuleOpPostfix"
    // InternalFLY.g:4201:1: entryRuleOpPostfix returns [String current=null] : iv_ruleOpPostfix= ruleOpPostfix EOF ;
    public final String entryRuleOpPostfix() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpPostfix = null;


        try {
            // InternalFLY.g:4201:49: (iv_ruleOpPostfix= ruleOpPostfix EOF )
            // InternalFLY.g:4202:2: iv_ruleOpPostfix= ruleOpPostfix EOF
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
    // InternalFLY.g:4208:1: ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' | kw= '--' ) ;
    public final AntlrDatatypeRuleToken ruleOpPostfix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4214:2: ( (kw= '++' | kw= '--' ) )
            // InternalFLY.g:4215:2: (kw= '++' | kw= '--' )
            {
            // InternalFLY.g:4215:2: (kw= '++' | kw= '--' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==57) ) {
                alt51=1;
            }
            else if ( (LA51_0==58) ) {
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
                    // InternalFLY.g:4216:3: kw= '++'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4222:3: kw= '--'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleArithmeticExpression"
    // InternalFLY.g:4231:1: entryRuleArithmeticExpression returns [EObject current=null] : iv_ruleArithmeticExpression= ruleArithmeticExpression EOF ;
    public final EObject entryRuleArithmeticExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmeticExpression = null;


        try {
            // InternalFLY.g:4231:61: (iv_ruleArithmeticExpression= ruleArithmeticExpression EOF )
            // InternalFLY.g:4232:2: iv_ruleArithmeticExpression= ruleArithmeticExpression EOF
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
    // InternalFLY.g:4238:1: ruleArithmeticExpression returns [EObject current=null] : this_OrExpression_0= ruleOrExpression ;
    public final EObject ruleArithmeticExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:4244:2: (this_OrExpression_0= ruleOrExpression )
            // InternalFLY.g:4245:2: this_OrExpression_0= ruleOrExpression
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
    // InternalFLY.g:4256:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalFLY.g:4256:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalFLY.g:4257:2: iv_ruleOrExpression= ruleOrExpression EOF
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
    // InternalFLY.g:4263:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:4269:2: ( (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalFLY.g:4270:2: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalFLY.g:4270:2: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalFLY.g:4271:3: this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_51);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:4279:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==59) ) {
                    int LA52_2 = input.LA(2);

                    if ( (synpred10_InternalFLY()) ) {
                        alt52=1;
                    }


                }


                switch (alt52) {
            	case 1 :
            	    // InternalFLY.g:4280:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalFLY.g:4280:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) )
            	    // InternalFLY.g:4281:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) )
            	    {
            	    // InternalFLY.g:4291:5: ( () ( (lv_feature_2_0= ruleOpOr ) ) )
            	    // InternalFLY.g:4292:6: () ( (lv_feature_2_0= ruleOpOr ) )
            	    {
            	    // InternalFLY.g:4292:6: ()
            	    // InternalFLY.g:4293:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:4299:6: ( (lv_feature_2_0= ruleOpOr ) )
            	    // InternalFLY.g:4300:7: (lv_feature_2_0= ruleOpOr )
            	    {
            	    // InternalFLY.g:4300:7: (lv_feature_2_0= ruleOpOr )
            	    // InternalFLY.g:4301:8: lv_feature_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getOrExpressionAccess().getFeatureOpOrParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_8);
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

            	    // InternalFLY.g:4320:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalFLY.g:4321:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalFLY.g:4321:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalFLY.g:4322:6: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_51);
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
            	    break loop52;
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
    // InternalFLY.g:4344:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalFLY.g:4344:44: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalFLY.g:4345:2: iv_ruleOpOr= ruleOpOr EOF
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
    // InternalFLY.g:4351:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'or' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4357:2: (kw= 'or' )
            // InternalFLY.g:4358:2: kw= 'or'
            {
            kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
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
    // InternalFLY.g:4366:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalFLY.g:4366:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalFLY.g:4367:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalFLY.g:4373:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:4379:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalFLY.g:4380:2: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalFLY.g:4380:2: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalFLY.g:4381:3: this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_52);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:4389:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==60) ) {
                    int LA53_2 = input.LA(2);

                    if ( (synpred11_InternalFLY()) ) {
                        alt53=1;
                    }


                }


                switch (alt53) {
            	case 1 :
            	    // InternalFLY.g:4390:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalFLY.g:4390:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) )
            	    // InternalFLY.g:4391:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) )
            	    {
            	    // InternalFLY.g:4401:5: ( () ( (lv_feature_2_0= ruleOpAnd ) ) )
            	    // InternalFLY.g:4402:6: () ( (lv_feature_2_0= ruleOpAnd ) )
            	    {
            	    // InternalFLY.g:4402:6: ()
            	    // InternalFLY.g:4403:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:4409:6: ( (lv_feature_2_0= ruleOpAnd ) )
            	    // InternalFLY.g:4410:7: (lv_feature_2_0= ruleOpAnd )
            	    {
            	    // InternalFLY.g:4410:7: (lv_feature_2_0= ruleOpAnd )
            	    // InternalFLY.g:4411:8: lv_feature_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAndExpressionAccess().getFeatureOpAndParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_8);
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

            	    // InternalFLY.g:4430:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalFLY.g:4431:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalFLY.g:4431:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalFLY.g:4432:6: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_52);
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
            	    break loop53;
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
    // InternalFLY.g:4454:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalFLY.g:4454:45: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalFLY.g:4455:2: iv_ruleOpAnd= ruleOpAnd EOF
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
    // InternalFLY.g:4461:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'and' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4467:2: (kw= 'and' )
            // InternalFLY.g:4468:2: kw= 'and'
            {
            kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
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
    // InternalFLY.g:4476:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalFLY.g:4476:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalFLY.g:4477:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalFLY.g:4483:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:4489:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalFLY.g:4490:2: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalFLY.g:4490:2: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // InternalFLY.g:4491:3: this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_53);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:4499:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==61) ) {
                    int LA54_2 = input.LA(2);

                    if ( (synpred12_InternalFLY()) ) {
                        alt54=1;
                    }


                }
                else if ( (LA54_0==62) ) {
                    int LA54_3 = input.LA(2);

                    if ( (synpred12_InternalFLY()) ) {
                        alt54=1;
                    }


                }


                switch (alt54) {
            	case 1 :
            	    // InternalFLY.g:4500:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
            	    {
            	    // InternalFLY.g:4500:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) )
            	    // InternalFLY.g:4501:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) )
            	    {
            	    // InternalFLY.g:4511:5: ( () ( (lv_feature_2_0= ruleOpEquality ) ) )
            	    // InternalFLY.g:4512:6: () ( (lv_feature_2_0= ruleOpEquality ) )
            	    {
            	    // InternalFLY.g:4512:6: ()
            	    // InternalFLY.g:4513:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:4519:6: ( (lv_feature_2_0= ruleOpEquality ) )
            	    // InternalFLY.g:4520:7: (lv_feature_2_0= ruleOpEquality )
            	    {
            	    // InternalFLY.g:4520:7: (lv_feature_2_0= ruleOpEquality )
            	    // InternalFLY.g:4521:8: lv_feature_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getEqualityExpressionAccess().getFeatureOpEqualityParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_8);
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

            	    // InternalFLY.g:4540:4: ( (lv_right_3_0= ruleRelationalExpression ) )
            	    // InternalFLY.g:4541:5: (lv_right_3_0= ruleRelationalExpression )
            	    {
            	    // InternalFLY.g:4541:5: (lv_right_3_0= ruleRelationalExpression )
            	    // InternalFLY.g:4542:6: lv_right_3_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_53);
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
            	    break loop54;
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
    // InternalFLY.g:4564:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalFLY.g:4564:50: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalFLY.g:4565:2: iv_ruleOpEquality= ruleOpEquality EOF
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
    // InternalFLY.g:4571:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4577:2: ( (kw= '==' | kw= '!=' ) )
            // InternalFLY.g:4578:2: (kw= '==' | kw= '!=' )
            {
            // InternalFLY.g:4578:2: (kw= '==' | kw= '!=' )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==61) ) {
                alt55=1;
            }
            else if ( (LA55_0==62) ) {
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
                    // InternalFLY.g:4579:3: kw= '=='
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4585:3: kw= '!='
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
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
    // InternalFLY.g:4594:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalFLY.g:4594:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalFLY.g:4595:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalFLY.g:4601:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:4607:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalFLY.g:4608:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalFLY.g:4608:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalFLY.g:4609:3: this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_54);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:4617:3: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                switch ( input.LA(1) ) {
                case 63:
                    {
                    int LA56_2 = input.LA(2);

                    if ( (synpred13_InternalFLY()) ) {
                        alt56=1;
                    }


                    }
                    break;
                case 64:
                    {
                    int LA56_3 = input.LA(2);

                    if ( (synpred13_InternalFLY()) ) {
                        alt56=1;
                    }


                    }
                    break;
                case 65:
                    {
                    int LA56_4 = input.LA(2);

                    if ( (synpred13_InternalFLY()) ) {
                        alt56=1;
                    }


                    }
                    break;
                case 66:
                    {
                    int LA56_5 = input.LA(2);

                    if ( (synpred13_InternalFLY()) ) {
                        alt56=1;
                    }


                    }
                    break;

                }

                switch (alt56) {
            	case 1 :
            	    // InternalFLY.g:4618:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalFLY.g:4618:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) )
            	    // InternalFLY.g:4619:5: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) )
            	    {
            	    // InternalFLY.g:4629:5: ( () ( (lv_feature_2_0= ruleOpCompare ) ) )
            	    // InternalFLY.g:4630:6: () ( (lv_feature_2_0= ruleOpCompare ) )
            	    {
            	    // InternalFLY.g:4630:6: ()
            	    // InternalFLY.g:4631:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:4637:6: ( (lv_feature_2_0= ruleOpCompare ) )
            	    // InternalFLY.g:4638:7: (lv_feature_2_0= ruleOpCompare )
            	    {
            	    // InternalFLY.g:4638:7: (lv_feature_2_0= ruleOpCompare )
            	    // InternalFLY.g:4639:8: lv_feature_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getRelationalExpressionAccess().getFeatureOpCompareParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_8);
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

            	    // InternalFLY.g:4658:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalFLY.g:4659:5: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalFLY.g:4659:5: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalFLY.g:4660:6: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_54);
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
            	    break loop56;
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
    // InternalFLY.g:4682:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalFLY.g:4682:49: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalFLY.g:4683:2: iv_ruleOpCompare= ruleOpCompare EOF
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
    // InternalFLY.g:4689:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '<' | kw= '>' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4695:2: ( (kw= '>=' | kw= '<=' | kw= '<' | kw= '>' ) )
            // InternalFLY.g:4696:2: (kw= '>=' | kw= '<=' | kw= '<' | kw= '>' )
            {
            // InternalFLY.g:4696:2: (kw= '>=' | kw= '<=' | kw= '<' | kw= '>' )
            int alt57=4;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt57=1;
                }
                break;
            case 64:
                {
                alt57=2;
                }
                break;
            case 65:
                {
                alt57=3;
                }
                break;
            case 66:
                {
                alt57=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalFLY.g:4697:3: kw= '>='
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4703:3: kw= '<='
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalFLY.g:4709:3: kw= '<'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalFLY.g:4715:3: kw= '>'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
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
    // InternalFLY.g:4724:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalFLY.g:4724:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalFLY.g:4725:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalFLY.g:4731:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:4737:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalFLY.g:4738:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalFLY.g:4738:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalFLY.g:4739:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_55);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:4747:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==67) ) {
                    int LA58_2 = input.LA(2);

                    if ( (synpred14_InternalFLY()) ) {
                        alt58=1;
                    }


                }
                else if ( (LA58_0==68) ) {
                    int LA58_3 = input.LA(2);

                    if ( (synpred14_InternalFLY()) ) {
                        alt58=1;
                    }


                }


                switch (alt58) {
            	case 1 :
            	    // InternalFLY.g:4748:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalFLY.g:4748:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) )
            	    // InternalFLY.g:4749:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    {
            	    // InternalFLY.g:4759:5: ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    // InternalFLY.g:4760:6: () ( (lv_feature_2_0= ruleOpAdd ) )
            	    {
            	    // InternalFLY.g:4760:6: ()
            	    // InternalFLY.g:4761:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:4767:6: ( (lv_feature_2_0= ruleOpAdd ) )
            	    // InternalFLY.g:4768:7: (lv_feature_2_0= ruleOpAdd )
            	    {
            	    // InternalFLY.g:4768:7: (lv_feature_2_0= ruleOpAdd )
            	    // InternalFLY.g:4769:8: lv_feature_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getFeatureOpAddParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_8);
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

            	    // InternalFLY.g:4788:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    // InternalFLY.g:4789:5: (lv_right_3_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalFLY.g:4789:5: (lv_right_3_0= ruleMultiplicativeExpression )
            	    // InternalFLY.g:4790:6: lv_right_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_55);
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
            	    break loop58;
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
    // InternalFLY.g:4812:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalFLY.g:4812:45: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalFLY.g:4813:2: iv_ruleOpAdd= ruleOpAdd EOF
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
    // InternalFLY.g:4819:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4825:2: ( (kw= '+' | kw= '-' ) )
            // InternalFLY.g:4826:2: (kw= '+' | kw= '-' )
            {
            // InternalFLY.g:4826:2: (kw= '+' | kw= '-' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==67) ) {
                alt59=1;
            }
            else if ( (LA59_0==68) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalFLY.g:4827:3: kw= '+'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4833:3: kw= '-'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
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
    // InternalFLY.g:4842:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalFLY.g:4842:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalFLY.g:4843:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalFLY.g:4849:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:4855:2: ( (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) )
            // InternalFLY.g:4856:2: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            {
            // InternalFLY.g:4856:2: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            // InternalFLY.g:4857:3: this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getUnaryOperationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_56);
            this_UnaryOperation_0=ruleUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_UnaryOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:4865:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==69) ) {
                    int LA60_2 = input.LA(2);

                    if ( (synpred15_InternalFLY()) ) {
                        alt60=1;
                    }


                }
                else if ( (LA60_0==70) ) {
                    int LA60_3 = input.LA(2);

                    if ( (synpred15_InternalFLY()) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // InternalFLY.g:4866:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) )
            	    {
            	    // InternalFLY.g:4866:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) )
            	    // InternalFLY.g:4867:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    {
            	    // InternalFLY.g:4877:5: ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    // InternalFLY.g:4878:6: () ( (lv_feature_2_0= ruleOpMulti ) )
            	    {
            	    // InternalFLY.g:4878:6: ()
            	    // InternalFLY.g:4879:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:4885:6: ( (lv_feature_2_0= ruleOpMulti ) )
            	    // InternalFLY.g:4886:7: (lv_feature_2_0= ruleOpMulti )
            	    {
            	    // InternalFLY.g:4886:7: (lv_feature_2_0= ruleOpMulti )
            	    // InternalFLY.g:4887:8: lv_feature_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getFeatureOpMultiParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_8);
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

            	    // InternalFLY.g:4906:4: ( (lv_right_3_0= ruleUnaryOperation ) )
            	    // InternalFLY.g:4907:5: (lv_right_3_0= ruleUnaryOperation )
            	    {
            	    // InternalFLY.g:4907:5: (lv_right_3_0= ruleUnaryOperation )
            	    // InternalFLY.g:4908:6: lv_right_3_0= ruleUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightUnaryOperationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_56);
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
            	    break loop60;
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
    // InternalFLY.g:4930:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalFLY.g:4930:47: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalFLY.g:4931:2: iv_ruleOpMulti= ruleOpMulti EOF
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
    // InternalFLY.g:4937:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:4943:2: ( (kw= '*' | kw= '/' ) )
            // InternalFLY.g:4944:2: (kw= '*' | kw= '/' )
            {
            // InternalFLY.g:4944:2: (kw= '*' | kw= '/' )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==69) ) {
                alt61=1;
            }
            else if ( (LA61_0==70) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalFLY.g:4945:3: kw= '*'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:4951:3: kw= '/'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalFLY.g:4960:1: entryRuleUnaryOperation returns [EObject current=null] : iv_ruleUnaryOperation= ruleUnaryOperation EOF ;
    public final EObject entryRuleUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperation = null;


        try {
            // InternalFLY.g:4960:55: (iv_ruleUnaryOperation= ruleUnaryOperation EOF )
            // InternalFLY.g:4961:2: iv_ruleUnaryOperation= ruleUnaryOperation EOF
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
    // InternalFLY.g:4967:1: ruleUnaryOperation returns [EObject current=null] : ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) ) | this_CastExpression_3= ruleCastExpression ) ;
    public final EObject ruleUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_feature_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_CastExpression_3 = null;



        	enterRule();

        try {
            // InternalFLY.g:4973:2: ( ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) ) | this_CastExpression_3= ruleCastExpression ) )
            // InternalFLY.g:4974:2: ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) ) | this_CastExpression_3= ruleCastExpression )
            {
            // InternalFLY.g:4974:2: ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) ) | this_CastExpression_3= ruleCastExpression )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=67 && LA62_0<=68)||LA62_0==71) ) {
                alt62=1;
            }
            else if ( ((LA62_0>=RULE_ID && LA62_0<=RULE_INT)||LA62_0==RULE_FLOAT||LA62_0==21||LA62_0==42||LA62_0==46||(LA62_0>=80 && LA62_0<=82)) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalFLY.g:4975:3: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) )
                    {
                    // InternalFLY.g:4975:3: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) ) )
                    // InternalFLY.g:4976:4: () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnaryOperation ) )
                    {
                    // InternalFLY.g:4976:4: ()
                    // InternalFLY.g:4977:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:4983:4: ( (lv_feature_1_0= ruleOpUnary ) )
                    // InternalFLY.g:4984:5: (lv_feature_1_0= ruleOpUnary )
                    {
                    // InternalFLY.g:4984:5: (lv_feature_1_0= ruleOpUnary )
                    // InternalFLY.g:4985:6: lv_feature_1_0= ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryOperationAccess().getFeatureOpUnaryParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
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

                    // InternalFLY.g:5002:4: ( (lv_operand_2_0= ruleUnaryOperation ) )
                    // InternalFLY.g:5003:5: (lv_operand_2_0= ruleUnaryOperation )
                    {
                    // InternalFLY.g:5003:5: (lv_operand_2_0= ruleUnaryOperation )
                    // InternalFLY.g:5004:6: lv_operand_2_0= ruleUnaryOperation
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
                    // InternalFLY.g:5023:3: this_CastExpression_3= ruleCastExpression
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
    // InternalFLY.g:5035:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalFLY.g:5035:47: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalFLY.g:5036:2: iv_ruleOpUnary= ruleOpUnary EOF
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
    // InternalFLY.g:5042:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:5048:2: ( (kw= 'not' | kw= '-' | kw= '+' ) )
            // InternalFLY.g:5049:2: (kw= 'not' | kw= '-' | kw= '+' )
            {
            // InternalFLY.g:5049:2: (kw= 'not' | kw= '-' | kw= '+' )
            int alt63=3;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt63=1;
                }
                break;
            case 68:
                {
                alt63=2;
                }
                break;
            case 67:
                {
                alt63=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // InternalFLY.g:5050:3: kw= 'not'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:5056:3: kw= '-'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalFLY.g:5062:3: kw= '+'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
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
    // InternalFLY.g:5071:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalFLY.g:5071:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalFLY.g:5072:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalFLY.g:5078:1: ruleCastExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )* ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_PrimaryExpression_0 = null;

        AntlrDatatypeRuleToken lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:5084:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )* ) )
            // InternalFLY.g:5085:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )* )
            {
            // InternalFLY.g:5085:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )* )
            // InternalFLY.g:5086:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCastExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_57);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalFLY.g:5094:3: ( ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==72) ) {
                    int LA65_2 = input.LA(2);

                    if ( (synpred16_InternalFLY()) ) {
                        alt65=1;
                    }


                }
                else if ( (LA65_0==73) ) {
                    int LA65_3 = input.LA(2);

                    if ( (synpred16_InternalFLY()) ) {
                        alt65=1;
                    }


                }


                switch (alt65) {
            	case 1 :
            	    // InternalFLY.g:5095:4: ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) ) ( (lv_type_3_0= ruleType ) )
            	    {
            	    // InternalFLY.g:5095:4: ( ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) ) )
            	    // InternalFLY.g:5096:5: ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) )
            	    {
            	    // InternalFLY.g:5110:5: ( () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) ) )
            	    // InternalFLY.g:5111:6: () ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) )
            	    {
            	    // InternalFLY.g:5111:6: ()
            	    // InternalFLY.g:5112:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getCastExpressionAccess().getCastExpressionTargetAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalFLY.g:5118:6: ( ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) ) )
            	    // InternalFLY.g:5119:7: ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) )
            	    {
            	    // InternalFLY.g:5119:7: ( (lv_op_2_1= 'as' | lv_op_2_2= 'parse' ) )
            	    // InternalFLY.g:5120:8: (lv_op_2_1= 'as' | lv_op_2_2= 'parse' )
            	    {
            	    // InternalFLY.g:5120:8: (lv_op_2_1= 'as' | lv_op_2_2= 'parse' )
            	    int alt64=2;
            	    int LA64_0 = input.LA(1);

            	    if ( (LA64_0==72) ) {
            	        alt64=1;
            	    }
            	    else if ( (LA64_0==73) ) {
            	        alt64=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 64, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt64) {
            	        case 1 :
            	            // InternalFLY.g:5121:9: lv_op_2_1= 'as'
            	            {
            	            lv_op_2_1=(Token)match(input,72,FOLLOW_58); if (state.failed) return current;
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
            	            // InternalFLY.g:5132:9: lv_op_2_2= 'parse'
            	            {
            	            lv_op_2_2=(Token)match(input,73,FOLLOW_58); if (state.failed) return current;
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

            	    // InternalFLY.g:5147:4: ( (lv_type_3_0= ruleType ) )
            	    // InternalFLY.g:5148:5: (lv_type_3_0= ruleType )
            	    {
            	    // InternalFLY.g:5148:5: (lv_type_3_0= ruleType )
            	    // InternalFLY.g:5149:6: lv_type_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeTypeParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_57);
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
            	    break loop65;
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
    // InternalFLY.g:5171:1: entryRuleType returns [String current=null] : iv_ruleType= ruleType EOF ;
    public final String entryRuleType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType = null;


        try {
            // InternalFLY.g:5171:44: (iv_ruleType= ruleType EOF )
            // InternalFLY.g:5172:2: iv_ruleType= ruleType EOF
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
    // InternalFLY.g:5178:1: ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'String' | kw= 'Integer' | kw= 'Date' | kw= 'Dat' | kw= 'Object' | kw= 'Double' ) ;
    public final AntlrDatatypeRuleToken ruleType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalFLY.g:5184:2: ( (kw= 'String' | kw= 'Integer' | kw= 'Date' | kw= 'Dat' | kw= 'Object' | kw= 'Double' ) )
            // InternalFLY.g:5185:2: (kw= 'String' | kw= 'Integer' | kw= 'Date' | kw= 'Dat' | kw= 'Object' | kw= 'Double' )
            {
            // InternalFLY.g:5185:2: (kw= 'String' | kw= 'Integer' | kw= 'Date' | kw= 'Dat' | kw= 'Object' | kw= 'Double' )
            int alt66=6;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt66=1;
                }
                break;
            case 75:
                {
                alt66=2;
                }
                break;
            case 76:
                {
                alt66=3;
                }
                break;
            case 77:
                {
                alt66=4;
                }
                break;
            case 78:
                {
                alt66=5;
                }
                break;
            case 79:
                {
                alt66=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalFLY.g:5186:3: kw= 'String'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeAccess().getStringKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalFLY.g:5192:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeAccess().getIntegerKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalFLY.g:5198:3: kw= 'Date'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeAccess().getDateKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalFLY.g:5204:3: kw= 'Dat'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeAccess().getDatKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalFLY.g:5210:3: kw= 'Object'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeAccess().getObjectKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalFLY.g:5216:3: kw= 'Double'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalFLY.g:5225:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalFLY.g:5225:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalFLY.g:5226:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalFLY.g:5232:1: rulePrimaryExpression returns [EObject current=null] : (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_LiteralExpression_1= ruleLiteralExpression | this_LocalFunctionCall_2= ruleLocalFunctionCall | this_MathFunction_3= ruleMathFunction | this_ChannelSend_4= ruleChannelSend | this_ChannelReceive_5= ruleChannelReceive | this_TimeFunction_6= ruleTimeFunction | this_VariableFunction_7= ruleVariableFunction ) ;
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
            // InternalFLY.g:5238:2: ( (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_LiteralExpression_1= ruleLiteralExpression | this_LocalFunctionCall_2= ruleLocalFunctionCall | this_MathFunction_3= ruleMathFunction | this_ChannelSend_4= ruleChannelSend | this_ChannelReceive_5= ruleChannelReceive | this_TimeFunction_6= ruleTimeFunction | this_VariableFunction_7= ruleVariableFunction ) )
            // InternalFLY.g:5239:2: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_LiteralExpression_1= ruleLiteralExpression | this_LocalFunctionCall_2= ruleLocalFunctionCall | this_MathFunction_3= ruleMathFunction | this_ChannelSend_4= ruleChannelSend | this_ChannelReceive_5= ruleChannelReceive | this_TimeFunction_6= ruleTimeFunction | this_VariableFunction_7= ruleVariableFunction )
            {
            // InternalFLY.g:5239:2: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_LiteralExpression_1= ruleLiteralExpression | this_LocalFunctionCall_2= ruleLocalFunctionCall | this_MathFunction_3= ruleMathFunction | this_ChannelSend_4= ruleChannelSend | this_ChannelReceive_5= ruleChannelReceive | this_TimeFunction_6= ruleTimeFunction | this_VariableFunction_7= ruleVariableFunction )
            int alt67=8;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // InternalFLY.g:5240:3: this_ParenthesizedExpression_0= ruleParenthesizedExpression
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
                    // InternalFLY.g:5249:3: this_LiteralExpression_1= ruleLiteralExpression
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
                    // InternalFLY.g:5258:3: this_LocalFunctionCall_2= ruleLocalFunctionCall
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
                    // InternalFLY.g:5267:3: this_MathFunction_3= ruleMathFunction
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
                    // InternalFLY.g:5276:3: this_ChannelSend_4= ruleChannelSend
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
                    // InternalFLY.g:5285:3: this_ChannelReceive_5= ruleChannelReceive
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
                    // InternalFLY.g:5294:3: this_TimeFunction_6= ruleTimeFunction
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
                    // InternalFLY.g:5303:3: this_VariableFunction_7= ruleVariableFunction
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
    // InternalFLY.g:5315:1: entryRuleLiteralExpression returns [EObject current=null] : iv_ruleLiteralExpression= ruleLiteralExpression EOF ;
    public final EObject entryRuleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpression = null;


        try {
            // InternalFLY.g:5315:58: (iv_ruleLiteralExpression= ruleLiteralExpression EOF )
            // InternalFLY.g:5316:2: iv_ruleLiteralExpression= ruleLiteralExpression EOF
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
    // InternalFLY.g:5322:1: ruleLiteralExpression returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral | this_ObjectLiteral_3= ruleObjectLiteral | this_VariableLiteral_4= ruleVariableLiteral | this_RangeLiteral_5= ruleRangeLiteral | this_FloatLiteral_6= ruleFloatLiteral ) ;
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
            // InternalFLY.g:5328:2: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral | this_ObjectLiteral_3= ruleObjectLiteral | this_VariableLiteral_4= ruleVariableLiteral | this_RangeLiteral_5= ruleRangeLiteral | this_FloatLiteral_6= ruleFloatLiteral ) )
            // InternalFLY.g:5329:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral | this_ObjectLiteral_3= ruleObjectLiteral | this_VariableLiteral_4= ruleVariableLiteral | this_RangeLiteral_5= ruleRangeLiteral | this_FloatLiteral_6= ruleFloatLiteral )
            {
            // InternalFLY.g:5329:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral | this_ObjectLiteral_3= ruleObjectLiteral | this_VariableLiteral_4= ruleVariableLiteral | this_RangeLiteral_5= ruleRangeLiteral | this_FloatLiteral_6= ruleFloatLiteral )
            int alt68=7;
            switch ( input.LA(1) ) {
            case 81:
            case 82:
                {
                alt68=1;
                }
                break;
            case RULE_INT:
                {
                alt68=2;
                }
                break;
            case RULE_STRING:
                {
                alt68=3;
                }
                break;
            case RULE_ID:
                {
                int LA68_4 = input.LA(2);

                if ( (LA68_4==EOF||LA68_4==RULE_ID||LA68_4==13||LA68_4==16||(LA68_4>=19 && LA68_4<=20)||(LA68_4>=22 && LA68_4<=24)||LA68_4==26||(LA68_4>=30 && LA68_4<=41)||LA68_4==43||LA68_4==45||(LA68_4>=47 && LA68_4<=48)||(LA68_4>=51 && LA68_4<=52)||(LA68_4>=55 && LA68_4<=56)||(LA68_4>=59 && LA68_4<=70)||(LA68_4>=72 && LA68_4<=73)) ) {
                    alt68=5;
                }
                else if ( (LA68_4==42||LA68_4==44) ) {
                    alt68=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 4, input);

                    throw nvae;
                }
                }
                break;
            case 42:
                {
                alt68=6;
                }
                break;
            case RULE_FLOAT:
                {
                alt68=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalFLY.g:5330:3: this_BooleanLiteral_0= ruleBooleanLiteral
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
                    // InternalFLY.g:5339:3: this_NumberLiteral_1= ruleNumberLiteral
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
                    // InternalFLY.g:5348:3: this_StringLiteral_2= ruleStringLiteral
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
                    // InternalFLY.g:5357:3: this_ObjectLiteral_3= ruleObjectLiteral
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
                    // InternalFLY.g:5366:3: this_VariableLiteral_4= ruleVariableLiteral
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
                    // InternalFLY.g:5375:3: this_RangeLiteral_5= ruleRangeLiteral
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
                    // InternalFLY.g:5384:3: this_FloatLiteral_6= ruleFloatLiteral
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
    // InternalFLY.g:5396:1: entryRuleTimeFunction returns [EObject current=null] : iv_ruleTimeFunction= ruleTimeFunction EOF ;
    public final EObject entryRuleTimeFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeFunction = null;


        try {
            // InternalFLY.g:5396:53: (iv_ruleTimeFunction= ruleTimeFunction EOF )
            // InternalFLY.g:5397:2: iv_ruleTimeFunction= ruleTimeFunction EOF
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
    // InternalFLY.g:5403:1: ruleTimeFunction returns [EObject current=null] : ( () otherlv_1= 'time' otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' ) ;
    public final EObject ruleTimeFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalFLY.g:5409:2: ( ( () otherlv_1= 'time' otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' ) )
            // InternalFLY.g:5410:2: ( () otherlv_1= 'time' otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' )
            {
            // InternalFLY.g:5410:2: ( () otherlv_1= 'time' otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')' )
            // InternalFLY.g:5411:3: () otherlv_1= 'time' otherlv_2= '(' ( (otherlv_3= RULE_ID ) )* otherlv_4= ')'
            {
            // InternalFLY.g:5411:3: ()
            // InternalFLY.g:5412:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTimeFunctionAccess().getTimeFunctionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,80,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTimeFunctionAccess().getTimeKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,21,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getTimeFunctionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalFLY.g:5426:3: ( (otherlv_3= RULE_ID ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==RULE_ID) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalFLY.g:5427:4: (otherlv_3= RULE_ID )
            	    {
            	    // InternalFLY.g:5427:4: (otherlv_3= RULE_ID )
            	    // InternalFLY.g:5428:5: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElement(grammarAccess.getTimeFunctionRule());
            	      					}
            	      				
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_59); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_3, grammarAccess.getTimeFunctionAccess().getValueVariableDeclarationCrossReference_3_0());
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
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
    // InternalFLY.g:5447:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalFLY.g:5447:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalFLY.g:5448:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalFLY.g:5454:1: ruleBooleanLiteral returns [EObject current=null] : ( ( () ( (lv_value_1_0= 'false' ) ) ) | ( () ( (lv_value_3_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalFLY.g:5460:2: ( ( ( () ( (lv_value_1_0= 'false' ) ) ) | ( () ( (lv_value_3_0= 'true' ) ) ) ) )
            // InternalFLY.g:5461:2: ( ( () ( (lv_value_1_0= 'false' ) ) ) | ( () ( (lv_value_3_0= 'true' ) ) ) )
            {
            // InternalFLY.g:5461:2: ( ( () ( (lv_value_1_0= 'false' ) ) ) | ( () ( (lv_value_3_0= 'true' ) ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==81) ) {
                alt70=1;
            }
            else if ( (LA70_0==82) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalFLY.g:5462:3: ( () ( (lv_value_1_0= 'false' ) ) )
                    {
                    // InternalFLY.g:5462:3: ( () ( (lv_value_1_0= 'false' ) ) )
                    // InternalFLY.g:5463:4: () ( (lv_value_1_0= 'false' ) )
                    {
                    // InternalFLY.g:5463:4: ()
                    // InternalFLY.g:5464:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:5470:4: ( (lv_value_1_0= 'false' ) )
                    // InternalFLY.g:5471:5: (lv_value_1_0= 'false' )
                    {
                    // InternalFLY.g:5471:5: (lv_value_1_0= 'false' )
                    // InternalFLY.g:5472:6: lv_value_1_0= 'false'
                    {
                    lv_value_1_0=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
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
                    // InternalFLY.g:5486:3: ( () ( (lv_value_3_0= 'true' ) ) )
                    {
                    // InternalFLY.g:5486:3: ( () ( (lv_value_3_0= 'true' ) ) )
                    // InternalFLY.g:5487:4: () ( (lv_value_3_0= 'true' ) )
                    {
                    // InternalFLY.g:5487:4: ()
                    // InternalFLY.g:5488:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalFLY.g:5494:4: ( (lv_value_3_0= 'true' ) )
                    // InternalFLY.g:5495:5: (lv_value_3_0= 'true' )
                    {
                    // InternalFLY.g:5495:5: (lv_value_3_0= 'true' )
                    // InternalFLY.g:5496:6: lv_value_3_0= 'true'
                    {
                    lv_value_3_0=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
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
    // InternalFLY.g:5513:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalFLY.g:5513:54: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalFLY.g:5514:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
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
    // InternalFLY.g:5520:1: ruleNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalFLY.g:5526:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalFLY.g:5527:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalFLY.g:5527:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // InternalFLY.g:5528:3: () ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalFLY.g:5528:3: ()
            // InternalFLY.g:5529:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getNumberLiteralAccess().getNumberLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:5535:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalFLY.g:5536:4: (lv_value_1_0= RULE_INT )
            {
            // InternalFLY.g:5536:4: (lv_value_1_0= RULE_INT )
            // InternalFLY.g:5537:5: lv_value_1_0= RULE_INT
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
    // InternalFLY.g:5557:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalFLY.g:5557:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalFLY.g:5558:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalFLY.g:5564:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalFLY.g:5570:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalFLY.g:5571:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalFLY.g:5571:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalFLY.g:5572:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalFLY.g:5572:3: ()
            // InternalFLY.g:5573:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:5579:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalFLY.g:5580:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalFLY.g:5580:4: (lv_value_1_0= RULE_STRING )
            // InternalFLY.g:5581:5: lv_value_1_0= RULE_STRING
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
    // InternalFLY.g:5601:1: entryRuleFloatLiteral returns [EObject current=null] : iv_ruleFloatLiteral= ruleFloatLiteral EOF ;
    public final EObject entryRuleFloatLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatLiteral = null;


        try {
            // InternalFLY.g:5601:53: (iv_ruleFloatLiteral= ruleFloatLiteral EOF )
            // InternalFLY.g:5602:2: iv_ruleFloatLiteral= ruleFloatLiteral EOF
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
    // InternalFLY.g:5608:1: ruleFloatLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) ;
    public final EObject ruleFloatLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalFLY.g:5614:2: ( ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) )
            // InternalFLY.g:5615:2: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            {
            // InternalFLY.g:5615:2: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            // InternalFLY.g:5616:3: () ( (lv_value_1_0= RULE_FLOAT ) )
            {
            // InternalFLY.g:5616:3: ()
            // InternalFLY.g:5617:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFloatLiteralAccess().getFloatLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:5623:3: ( (lv_value_1_0= RULE_FLOAT ) )
            // InternalFLY.g:5624:4: (lv_value_1_0= RULE_FLOAT )
            {
            // InternalFLY.g:5624:4: (lv_value_1_0= RULE_FLOAT )
            // InternalFLY.g:5625:5: lv_value_1_0= RULE_FLOAT
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
    // InternalFLY.g:5645:1: entryRuleVariableLiteral returns [EObject current=null] : iv_ruleVariableLiteral= ruleVariableLiteral EOF ;
    public final EObject entryRuleVariableLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableLiteral = null;


        try {
            // InternalFLY.g:5645:56: (iv_ruleVariableLiteral= ruleVariableLiteral EOF )
            // InternalFLY.g:5646:2: iv_ruleVariableLiteral= ruleVariableLiteral EOF
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
    // InternalFLY.g:5652:1: ruleVariableLiteral returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleVariableLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalFLY.g:5658:2: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // InternalFLY.g:5659:2: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalFLY.g:5659:2: ( () ( (otherlv_1= RULE_ID ) ) )
            // InternalFLY.g:5660:3: () ( (otherlv_1= RULE_ID ) )
            {
            // InternalFLY.g:5660:3: ()
            // InternalFLY.g:5661:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableLiteralAccess().getVariableLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalFLY.g:5667:3: ( (otherlv_1= RULE_ID ) )
            // InternalFLY.g:5668:4: (otherlv_1= RULE_ID )
            {
            // InternalFLY.g:5668:4: (otherlv_1= RULE_ID )
            // InternalFLY.g:5669:5: otherlv_1= RULE_ID
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
    // InternalFLY.g:5684:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // InternalFLY.g:5684:64: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // InternalFLY.g:5685:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
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
    // InternalFLY.g:5691:1: ruleParenthesizedExpression returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_expression_2_0= ruleArithmeticExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalFLY.g:5697:2: ( ( () otherlv_1= '(' ( (lv_expression_2_0= ruleArithmeticExpression ) ) otherlv_3= ')' ) )
            // InternalFLY.g:5698:2: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleArithmeticExpression ) ) otherlv_3= ')' )
            {
            // InternalFLY.g:5698:2: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleArithmeticExpression ) ) otherlv_3= ')' )
            // InternalFLY.g:5699:3: () otherlv_1= '(' ( (lv_expression_2_0= ruleArithmeticExpression ) ) otherlv_3= ')'
            {
            // InternalFLY.g:5699:3: ()
            // InternalFLY.g:5700:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParenthesizedExpressionAccess().getParenthesizedExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,21,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalFLY.g:5710:3: ( (lv_expression_2_0= ruleArithmeticExpression ) )
            // InternalFLY.g:5711:4: (lv_expression_2_0= ruleArithmeticExpression )
            {
            // InternalFLY.g:5711:4: (lv_expression_2_0= ruleArithmeticExpression )
            // InternalFLY.g:5712:5: lv_expression_2_0= ruleArithmeticExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionArithmeticExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_10);
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
        // InternalFLY.g:670:5: ( 'else' )
        // InternalFLY.g:670:6: 'else'
        {
        match(input,23,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalFLY

    // $ANTLR start synpred10_InternalFLY
    public final void synpred10_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:4281:5: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalFLY.g:4281:6: ( () ( ( ruleOpOr ) ) )
        {
        // InternalFLY.g:4281:6: ( () ( ( ruleOpOr ) ) )
        // InternalFLY.g:4282:6: () ( ( ruleOpOr ) )
        {
        // InternalFLY.g:4282:6: ()
        // InternalFLY.g:4283:6: 
        {
        }

        // InternalFLY.g:4284:6: ( ( ruleOpOr ) )
        // InternalFLY.g:4285:7: ( ruleOpOr )
        {
        // InternalFLY.g:4285:7: ( ruleOpOr )
        // InternalFLY.g:4286:8: ruleOpOr
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
    // $ANTLR end synpred10_InternalFLY

    // $ANTLR start synpred11_InternalFLY
    public final void synpred11_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:4391:5: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalFLY.g:4391:6: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalFLY.g:4391:6: ( () ( ( ruleOpAnd ) ) )
        // InternalFLY.g:4392:6: () ( ( ruleOpAnd ) )
        {
        // InternalFLY.g:4392:6: ()
        // InternalFLY.g:4393:6: 
        {
        }

        // InternalFLY.g:4394:6: ( ( ruleOpAnd ) )
        // InternalFLY.g:4395:7: ( ruleOpAnd )
        {
        // InternalFLY.g:4395:7: ( ruleOpAnd )
        // InternalFLY.g:4396:8: ruleOpAnd
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
    // $ANTLR end synpred11_InternalFLY

    // $ANTLR start synpred12_InternalFLY
    public final void synpred12_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:4501:5: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalFLY.g:4501:6: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalFLY.g:4501:6: ( () ( ( ruleOpEquality ) ) )
        // InternalFLY.g:4502:6: () ( ( ruleOpEquality ) )
        {
        // InternalFLY.g:4502:6: ()
        // InternalFLY.g:4503:6: 
        {
        }

        // InternalFLY.g:4504:6: ( ( ruleOpEquality ) )
        // InternalFLY.g:4505:7: ( ruleOpEquality )
        {
        // InternalFLY.g:4505:7: ( ruleOpEquality )
        // InternalFLY.g:4506:8: ruleOpEquality
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
    // $ANTLR end synpred12_InternalFLY

    // $ANTLR start synpred13_InternalFLY
    public final void synpred13_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:4619:5: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalFLY.g:4619:6: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalFLY.g:4619:6: ( () ( ( ruleOpCompare ) ) )
        // InternalFLY.g:4620:6: () ( ( ruleOpCompare ) )
        {
        // InternalFLY.g:4620:6: ()
        // InternalFLY.g:4621:6: 
        {
        }

        // InternalFLY.g:4622:6: ( ( ruleOpCompare ) )
        // InternalFLY.g:4623:7: ( ruleOpCompare )
        {
        // InternalFLY.g:4623:7: ( ruleOpCompare )
        // InternalFLY.g:4624:8: ruleOpCompare
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
    // $ANTLR end synpred13_InternalFLY

    // $ANTLR start synpred14_InternalFLY
    public final void synpred14_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:4749:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalFLY.g:4749:6: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalFLY.g:4749:6: ( () ( ( ruleOpAdd ) ) )
        // InternalFLY.g:4750:6: () ( ( ruleOpAdd ) )
        {
        // InternalFLY.g:4750:6: ()
        // InternalFLY.g:4751:6: 
        {
        }

        // InternalFLY.g:4752:6: ( ( ruleOpAdd ) )
        // InternalFLY.g:4753:7: ( ruleOpAdd )
        {
        // InternalFLY.g:4753:7: ( ruleOpAdd )
        // InternalFLY.g:4754:8: ruleOpAdd
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
    // $ANTLR end synpred14_InternalFLY

    // $ANTLR start synpred15_InternalFLY
    public final void synpred15_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:4867:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalFLY.g:4867:6: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalFLY.g:4867:6: ( () ( ( ruleOpMulti ) ) )
        // InternalFLY.g:4868:6: () ( ( ruleOpMulti ) )
        {
        // InternalFLY.g:4868:6: ()
        // InternalFLY.g:4869:6: 
        {
        }

        // InternalFLY.g:4870:6: ( ( ruleOpMulti ) )
        // InternalFLY.g:4871:7: ( ruleOpMulti )
        {
        // InternalFLY.g:4871:7: ( ruleOpMulti )
        // InternalFLY.g:4872:8: ruleOpMulti
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
    // $ANTLR end synpred15_InternalFLY

    // $ANTLR start synpred16_InternalFLY
    public final void synpred16_InternalFLY_fragment() throws RecognitionException {   
        // InternalFLY.g:5096:5: ( ( () ( ( ( 'as' | 'parse' ) ) ) ) )
        // InternalFLY.g:5096:6: ( () ( ( ( 'as' | 'parse' ) ) ) )
        {
        // InternalFLY.g:5096:6: ( () ( ( ( 'as' | 'parse' ) ) ) )
        // InternalFLY.g:5097:6: () ( ( ( 'as' | 'parse' ) ) )
        {
        // InternalFLY.g:5097:6: ()
        // InternalFLY.g:5098:6: 
        {
        }

        // InternalFLY.g:5099:6: ( ( ( 'as' | 'parse' ) ) )
        // InternalFLY.g:5100:7: ( ( 'as' | 'parse' ) )
        {
        // InternalFLY.g:5100:7: ( ( 'as' | 'parse' ) )
        // InternalFLY.g:5101:8: ( 'as' | 'parse' )
        {
        if ( (input.LA(1)>=72 && input.LA(1)<=73) ) {
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
    // $ANTLR end synpred16_InternalFLY

    // Delegated rules

    public final boolean synpred13_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalFLY_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred10_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalFLY_fragment(); // can never throw exception
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
    public final boolean synpred11_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalFLY_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalFLY() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalFLY_fragment(); // can never throw exception
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
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA67 dfa67 = new DFA67(this);
    static final String dfa_1s = "\26\uffff";
    static final String dfa_2s = "\1\4\1\21\16\uffff\1\4\3\uffff\1\21\1\uffff";
    static final String dfa_3s = "\1\70\1\72\16\uffff\1\4\3\uffff\1\25\1\uffff";
    static final String dfa_4s = "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\16\1\21\1\22\1\1\1\15\1\uffff\1\13\1\20\1\14\1\uffff\1\17";
    static final String dfa_5s = "\26\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\10\uffff\1\13\5\uffff\1\6\1\3\3\uffff\1\4\6\uffff\1\5\1\2\1\uffff\10\12\5\uffff\1\10\1\7\2\uffff\2\11\2\uffff\1\15\1\14",
            "\2\16\2\uffff\1\17\24\uffff\1\16\1\uffff\1\20\4\uffff\1\21\1\23\6\uffff\2\22",
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
            "\1\24",
            "",
            "",
            "",
            "\2\16\2\uffff\1\25",
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
            return "114:2: (this_Assignment_0= ruleAssignment | this_BlockExpression_1= ruleBlockExpression | this_IfExpression_2= ruleIfExpression | this_ForExpression_3= ruleForExpression | this_WhileExpression_4= ruleWhileExpression | this_PrintExpression_5= rulePrintExpression | this_FunctionDefinition_6= ruleFunctionDefinition | this_FunctionReturn_7= ruleFunctionReturn | this_FlyFunctionCall_8= ruleFlyFunctionCall | this_VariableDeclaration_9= ruleVariableDeclaration | this_ChannelSend_10= ruleChannelSend | this_ChannelReceive_11= ruleChannelReceive | this_LocalFunctionCall_12= ruleLocalFunctionCall | this_SortExpression_13= ruleSortExpression | this_VariableFunction_14= ruleVariableFunction | this_PostfixOperation_15= rulePostfixOperation | this_RequireExpression_16= ruleRequireExpression | this_NativeExpression_17= ruleNativeExpression )";
        }
    }
    static final String dfa_7s = "\21\uffff";
    static final String dfa_8s = "\1\4\1\52\1\uffff\2\4\2\36\1\uffff\2\55\1\5\1\uffff\1\4\1\uffff\2\53\1\36";
    static final String dfa_9s = "\1\4\1\54\1\uffff\1\122\1\6\2\111\1\uffff\2\55\1\52\1\uffff\1\6\1\uffff\2\53\1\111";
    static final String dfa_10s = "\2\uffff\1\1\4\uffff\1\2\3\uffff\1\3\1\uffff\1\4\3\uffff";
    static final String dfa_11s = "\21\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\3\1\uffff\1\2",
            "",
            "\1\7\1\6\1\5\1\uffff\1\7\14\uffff\1\7\24\uffff\1\4\3\uffff\1\7\24\uffff\2\7\2\uffff\1\7\10\uffff\3\7",
            "\1\11\1\uffff\1\10",
            "\1\12\14\uffff\1\7\1\uffff\1\7\15\uffff\14\7\1\uffff\2\7",
            "\1\13\14\uffff\1\7\1\uffff\1\7\15\uffff\14\7\1\uffff\2\7",
            "",
            "\1\14",
            "\1\14",
            "\2\13\43\uffff\1\15",
            "",
            "\1\17\1\uffff\1\16",
            "",
            "\1\20",
            "\1\20",
            "\1\15\14\uffff\1\7\1\uffff\1\7\15\uffff\14\7\1\uffff\2\7"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "2588:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_value_3_0= RULE_ID ) ) ) | ( () ( (otherlv_5= RULE_ID ) ) ( (lv_indexes_6_0= ruleSubIndex ) ) ( (lv_indexes_7_0= ruleSubIndex ) )* ) | ( () ( (otherlv_9= RULE_ID ) ) otherlv_10= '[' ( ( (lv_value1_11_1= ruleNumberLiteral | lv_value1_11_2= ruleStringLiteral ) ) ) otherlv_12= ',' ( ( (lv_value2_13_1= ruleNumberLiteral | lv_value2_13_2= ruleStringLiteral ) ) ) otherlv_14= ']' ) | ( () ( (otherlv_16= RULE_ID ) ) otherlv_17= '[' ( ( (lv_range1_18_0= ruleRangeLiteral ) ) | ( (lv_range1_t_19_0= ruleNumberLiteral ) ) ) otherlv_20= ',' ( (lv_range2_21_0= ruleRangeLiteral ) ) otherlv_22= ']' ) )";
        }
    }
    static final String dfa_13s = "\14\uffff";
    static final String dfa_14s = "\3\uffff\1\2\6\uffff\1\2\1\uffff";
    static final String dfa_15s = "\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff";
    static final String dfa_16s = "\1\122\2\uffff\1\111\5\uffff\1\4\1\111\1\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\7\1\6\1\3\1\5\2\uffff\1\10";
    static final String dfa_18s = "\14\uffff}>";
    static final String[] dfa_19s = {
            "\1\3\2\2\1\uffff\1\2\14\uffff\1\1\24\uffff\1\2\3\uffff\1\4\41\uffff\1\5\2\2",
            "",
            "",
            "\1\2\10\uffff\1\2\2\uffff\1\2\2\uffff\2\2\1\7\3\2\1\uffff\1\2\3\uffff\16\2\1\11\1\2\1\uffff\2\2\1\10\1\6\2\2\2\uffff\2\2\2\uffff\14\2\1\uffff\2\2",
            "",
            "",
            "",
            "",
            "",
            "\1\12",
            "\1\2\10\uffff\1\2\2\uffff\1\2\2\uffff\2\2\1\13\3\2\1\uffff\1\2\3\uffff\14\2\1\uffff\1\2\1\uffff\1\2\1\uffff\2\2\2\uffff\2\2\2\uffff\2\2\2\uffff\14\2\1\uffff\2\2",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "5239:2: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_LiteralExpression_1= ruleLiteralExpression | this_LocalFunctionCall_2= ruleLocalFunctionCall | this_MathFunction_3= ruleMathFunction | this_ChannelSend_4= ruleChannelSend | this_ChannelReceive_5= ruleChannelReceive | this_TimeFunction_6= ruleTimeFunction | this_VariableFunction_7= ruleVariableFunction )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x019983FD81182012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000440000200170L,0x0000000000070098L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x019983FD81982010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x019983FD81182010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x019983FD85182010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000038000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x019983FF81182010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0018440100200170L,0x000000000007FC98L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000440100200170L,0x000000000007FC98L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000440340200170L,0x000000000007FC98L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00004C0040200170L,0x0000000000070098L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000080040000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000070L,0x0000000000060000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000040000000040L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000280000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000440040600170L,0x0000000000070098L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000040400000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000040400010L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000002210000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000007L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x000000000000FC00L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000400010L});

}