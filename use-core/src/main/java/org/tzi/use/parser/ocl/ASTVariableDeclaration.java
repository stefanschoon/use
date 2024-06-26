/*
 * USE - UML based specification environment
 * Copyright (C) 1999-2004 Mark Richters, University of Bremen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.tzi.use.parser.ocl;

import org.antlr.runtime.Token;
import org.tzi.use.parser.AST;
import org.tzi.use.parser.Context;
import org.tzi.use.parser.SemanticException;
import org.tzi.use.uml.ocl.expr.VarDecl;
import org.tzi.use.uml.ocl.type.Type;

/**
 * Node of the abstract syntax tree constructed by the parser.
 *
 * @author  Mark Richters
 */
public class ASTVariableDeclaration extends AST {
    private Token fName;
    private ASTType fType;

    /**
     * 
     * @param name 
     * @param type The AST node of the type of the variable. Cannot be <code>null</code>.
     */
    public ASTVariableDeclaration(Token name, ASTType type) {
        fName = name;
        fType = type;
    }

    public VarDecl gen(Context ctx) 
        throws SemanticException 
    {
        Type type = fType.gen(ctx);
        return new VarDecl(fName.getText(), type); 
    }

    public Token name() {
        return fName;
    }
    
    public ASTType getType() {
        return fType;
    }

    @Override
    public String toString() {
    	return fName.getText() + ":" + fType.toString(); 
    }
}

