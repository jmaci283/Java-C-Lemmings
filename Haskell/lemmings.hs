--NAME:		James MacIsaac
--EMAIL:	jmaci283@mtroyal.ca
--FILE:		lemmings.hs
--COURSE:	COMP 3649

-- First off, let's make some types

-- Positions (ordered pair of ints saying where a thing is)
data Position = MakePosition Int Int

instance Show Position where
    show (MakePosition x y) = "(" ++ (show x) ++ "," ++ (show y) ++ ")"

-- 2D array of stuff in the level	
data World = MakeWorld [[Char]]	

instance Show World where
	show (MakeWorld w) = "World " ++ show w

-- Initial Lemming Placements
data OGroup = MakeOGroup Position Int

instance Show OGroup where	
	show (MakeOGroup x t) =  "Ordered Group { Position: " ++ (show x) ++ ", Time: " ++ (show t) ++ " }"

-- Lemming type	
data Lemming = MakeLemming 	Position			-- location of the lemming
							Bool				-- orientation
							Int					-- ability ( 	0 = no ability
												--				1 = basher
												--				2 = digger	)

instance Show Lemming where
	show (MakeLemming pos ori abil) =
		"Lemming Position:\n\t" 
			++ (show pos) ++ "\n"
			++ "Orientation:\n\t"
			++ (show ori) ++ "\n"
			++ "Ability:\n\t"
			++ (show abil) ++ "\n"
	
-- World Cell Type
data WorldCell = MakeWorldCell	Char			-- Cell type
								[Lemming]		-- list of lemmings

instance Show WorldCell where
	show (MakeWorldCell c lemList) =
		"Cell Type:\n\t" ++ (show c) ++ "\n"
			++ "Present Lemmings:\n"
			++ "\t" ++ (show lemList) ++ "\n"
	
-- Level Type
data Level = MakeLevel	Int						-- Time Limit
						Int						-- Need Saving
						Int						-- Released
						[OGroup]				-- Lemming Starting Positions and Times
						Int						-- Bashers
						Int						-- Diggers
						Position				-- World Size
						Position				-- Exit Location
						World					-- World Cells
						
instance Show Level where
    show (MakeLevel t s r initLoc b d wSize exLoc worldConf) =
	   "Level contents: \n\t" ++ (show t) ++ "\n\t" 
			++ (show s) ++ "\n\t" 
			++ (show r) ++ "\n\t" 
			++ (show initLoc) ++ "\n\t" 
			++ (show b) ++ "\n\t" 
			++ (show d) ++ "\n\t" 
			++ (show wSize) ++ "\n\t" 
			++ (show exLoc) ++ "\n\t" 
			++ (show worldConf)			

-- need to make the world get reformatted tot he new type which includes cell fields			

--test level to play with
testData1 :: Level
testData1 = MakeLevel
			  1000
			  1
			  2
              [(MakeOGroup (MakePosition 1 3) 1), 
 			   (MakeOGroup (MakePosition 1 3) 5)]
              0
              0
              (MakePosition 10 5)
              (MakePosition 8 1)
			  (MakeWorld 
			   ["dddddddddd",  -- zero is a the bottom so this appears upsidedown
			    "aaaaaaaaaa",
			    "aaaaaaaaaa",
			    "aaaaaaaaaa",
			    "aaaaaaaaaa"])

convertWorldFormat :: Level -> 				
-- solution stubb area				
data Solution = MakeSolution [(OGroup, Char)]

-- This shit needs to be improved and actually do something
instance Show Solution where
    show (MakeSolution xs) = (show xs)
				
-- Stubb				
solver :: Level -> Solution
solver x = (MakeSolution [])
