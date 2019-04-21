start_section:

tickets: array (tasks_range) of integer;
to_run : integer;
mul : integer;
i : integer;
a:integer;
b:integer;
ta:integer;
t:integer;
n:integer;
m:integer;
count:integer;
seed_gen: random;
comp:integer;
finished:integer;
time:integer;
time:=-1;
maxt:integer;

end section;


priority_section:

time:=time+1;
put("For time: ");
put(time);
a:=1;
b:=1;
t:=1;


-- The following code calculates LCM of capacity of all the tasks.
  for i in tasks_range loop
		if tasks.ready(i)=true then
        			b:=tasks.capacity(i);

					if(a<b)
					then
						t:=b;
					else
						t:=a;
					end if;

					ta:=1;

					while ta/=0 loop
					-- ta:= t mod b + t mod a;
					m:=t mod a;
					n:=t mod b;

					ta:=m+n;

					--put(t);
					--put(t mod b);
					--put(t mod a);
					--put(ta);
					t:=t+1;
					end loop;

					t:=t-1;
					a:=t;
		end if;
	end loop;

mul:=a;

--maxt refers to total number of tickets given away

maxt:=0;
for i in tasks_range loop
		if tasks.ready(i)=true then
		a:=mul/tasks.capacity(i);
		maxt:=maxt+a;
		end if;
end loop;


uniform(seed_gen,1,maxt);
-- uniform gives a random value to seed_gen between 1->maxt
-- Limit is inclusive of both a,b in uniform (a,b)

count:=0;
finished:=0;


--put is used to print statements in the debug section

put("lcm is");
put(mul);


put("with tickets till");
put(maxt);


put("with seed_gen");
put(seed_gen);


--The following code selects the task which has a ticket of value seed_gen
--For each task, it calculates its ticket by adding up all the previous ticket with its current ticket( LCM / capacity of the task)

for i in tasks_range loop
		if tasks.ready(i)=true then
		--Doubt: Why was "and finished = 0" not working ???
			if(finished=0)
				then	
					put("inside");
					put(i);

					put("Has tickets till");
					a:=mul/tasks.capacity(i);
					comp:=a+count;
					put(comp);

					--Checks if the current task has tickets in the value of random number generated

					if comp>=seed_gen then
							put("Changed to_run");
							to_run:=i; 
							finished:=1;
							--i:=nb_tasks;  This didnt work. Why??
					else
							put("DIdnt change to_run");
							b:=mul/tasks.capacity(i);
							count:=count+b;
				end if;
			end if;
		end if;
	--	exit when finished;
end loop;
put("So we ran;");
put(to_run);
put("ending i:");
put(i);


end section;

election_section:
	return to_run;
end section;